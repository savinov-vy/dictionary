package ru.savinov.dictionary.backend.concurrent.Atomic;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestAtomic {
    static final int THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TestAtomic testAtomic = new TestAtomic();

        for (int i = 0; i < 20; i++) {
            testAtomic.testWithOutputResult(new DoOnceDoer());
            testAtomic.testWithOutputResult(new DoOnceDoer());
            testAtomic.testWithExecutorService(new DoOnceDoer());

            testAtomic.testWithOutputResult(new DoOnceBoolean());
            testAtomic.testWithOutputResult(new DoOnceBoolean());
            testAtomic.testWithExecutorService(new DoOnceBoolean());
        }
    }

    private void simpleTestDoer(IOnceDoer doer) throws InterruptedException {
        Runnable r = () -> {
            doer.doOnce(() -> System.out.println("In thread " + Thread.currentThread()));
        };

        List<Thread> threads = Stream.generate(() -> new Thread(r))
                .limit(THREADS).peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }
    }

    private void testWithOutputResult(IOnceDoer doer) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger count = new AtomicInteger();

        Runnable r = () -> {
            try {
                latch.await();
            } catch (InterruptedException ignored) {
            }
            doer.doOnce(count::incrementAndGet);
        };
        List<Thread> threads = Stream.generate(() -> new Thread(r))
                .limit(THREADS).peek(Thread::start)
                .collect(Collectors.toList());
        latch.countDown();
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.printf("done %d times, expected 1 times%n", count.get());
    }

    private void testWithExecutorService(IOnceDoer doer) throws ExecutionException, InterruptedException {
        AtomicReference<IOnceDoer> doerRef = new AtomicReference<>();
        AtomicInteger count = new AtomicInteger();

        Runnable r = () -> doerRef.get().doOnce(count::incrementAndGet);
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        count.set(0);
        doerRef.set(doer);
        List<Future<?>> futures = Stream.generate(() -> executorService.submit(r))
                .limit(THREADS).collect(Collectors.toList());
        for (Future<?> future : futures) {
            future.get();
        }
        if (count.get() == 1) {
            System.out.println("Test accepted");
        } else {
            System.out.println("Test filed");
        }
        executorService.shutdown();
    }
}


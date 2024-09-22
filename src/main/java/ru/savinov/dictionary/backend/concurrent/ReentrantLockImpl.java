package ru.savinov.dictionary.backend.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockImpl {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(counter::countTo100_000);
        executorService.submit(counter::countTo100_000);
        executorService.shutdown();

        executorService.awaitTermination(2, TimeUnit.HOURS);
        System.out.println(counter.getCounted());
    }
}


class Counter {
    private int counted;
    Lock lock = new ReentrantLock();

    public void countTo100_000() {
        lock.lock();
        for (int i = 0; i < 100_000; i++) {
            counted++;
        }
        lock.unlock();
    }

    public int getCounted() {
        return counted;
    }
}

package ru.savinov.dictionary.backend.theoryCore.concurrent;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExecutorServiceImpl {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ProducerConsumer work = new ProducerConsumer();
        executorService.submit(work::produce);
        executorService.submit(work::consume);
        executorService.submit(work::isStop);
        executorService.shutdown();
    }
}

class ProducerConsumer {
    volatile boolean start = true;
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

    public void produce() {
        Random random = new Random();
        while (start) {
            try {
                System.out.println("Put "+ Thread.currentThread().getName());
                int size = blockingQueue.size();
                blockingQueue.put(random.nextInt(1000) +" size Queue is: " + size);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() {
        while (start) {
            try {
                String taked = blockingQueue.take();
                System.out.println("Take "+ Thread.currentThread().getName());
                System.out.println(taked);
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void isStop() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        start = false;
        System.out.println("Is stopped Tread name" + Thread.currentThread().getName());
    }

}

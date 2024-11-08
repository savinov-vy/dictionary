package ru.savinov.dictionary.backend.concurrent.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Если в ресурс никто не пишет, то можно свободно читать несколькими потоками. Если кто-то пишет то паралельно
 * нельзя ни читать не писать. Эта возможность используется с помощью ReentrantReadWriteLock.
 * С помощью ReentrantLock такой возможности добиться нельзя
 * ReentrantReadWriteLock - если 10 потоков вызовут get то все 10 потоков будут читать параллельно. Если
 * Если в этот момент одному Thread-у необходимо сделать запись, то он дождётся когда все закончат читать
 * потом заблокирует на запись и запишет.
 */
public class ReentrantReadWriteLockEx {
    class ThreadSafeList {
        private final List<String> list = new ArrayList<>();
        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        String get(int i) {
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
            readLock.lock();
            try {
                return list.get(i);
            } finally {
                readLock.unlock();
            }
        }

        void add(String s) {
            ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
            writeLock.lock();
            try {
                list.add(s);
            } finally {
                writeLock.unlock();
            }
        }
    }
}

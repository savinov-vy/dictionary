package ru.savinov.dictionary.backend.concurrent.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    static class ThreadSafeList {
        private final List<String> list = new ArrayList<>();
        private final ReentrantLock lock = new ReentrantLock(true); //true - честный - стримы согласно очереди, а не приоритета

        String get(int i) {
            lock.lock();
            try {
                return list.get(i);
            } finally {
                lock.unlock();
            }
        }

        void add (String str) {
            lock.lock();
            try {
                list.add(str);
            } finally {
                lock.unlock();
            }
        }

    }
}

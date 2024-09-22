package ru.savinov.dictionary.backend.concurrent.Atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Альтернативный вариант DoOnce если DoOnceBoolean уже не устраивает по производительности
 * этот вариант быстрее, но хуже читается (сложнее)
 */
public class DoOnceDoer implements IOnceDoer {

    private volatile int flag = 0;

    private static final AtomicIntegerFieldUpdater<DoOnceDoer> FLAG_UPDATER =
            AtomicIntegerFieldUpdater.newUpdater(DoOnceDoer.class, "flag");

    public void doOnce(Runnable action) {
        if (FLAG_UPDATER.compareAndSet(this, 0, 1)) {
            action.run();
        }
    }

}

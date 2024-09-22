package ru.savinov.dictionary.backend.concurrent.Atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoOnceBoolean {
    AtomicBoolean flag = new AtomicBoolean(false);

    /**
     * если удалось сменить false -> true то compareAndSet(false, true) вернёт true
     * если там true то не удастся сменить и вернёт false
     * compareAndSet имеет особую инструкцию для процессора для увеличения скорости работы
     * @param action
     */
    void doOnce(Runnable action) {
        if (flag.compareAndSet(false, true)) {
            action.run();
        }
    }
}

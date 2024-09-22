package ru.savinov.dictionary.backend.concurrent.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * в примере приведён вариант удваивания значения AtomicInteger - сделать это атомарно
 * (чтение, удваивание, запись)
 * это называется CastLoop или CompareAndSetLoop
 * читаем текущее значение, и если оно не было изменено другим потоком то замени на cur * 2
 * если кто-то заменил значение (возможно и несколько потоков), то мы не выполняем операцию и идём на следующий цикл:
 * заново читаем значение и т.д.
 * инкремент на 1 реализован в AtomicInteger
 */
public class CompareAndSet {

    int getAndDouble(AtomicInteger i) {
        int cur;
        do {
            cur = i.get();
        } while (!i.compareAndSet(cur, cur * 2));
        return cur;
    }

    int getAndDouble(AtomicInteger i, int n) {
        return i.getAndUpdate(val -> val * n);
    }
}

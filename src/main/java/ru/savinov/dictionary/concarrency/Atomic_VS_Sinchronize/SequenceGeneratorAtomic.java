package ru.savinov.dictionary.concarrency.Atomic_VS_Sinchronize;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGeneratorAtomic implements Generatorable {
    private AtomicInteger number = new AtomicInteger();

    public int generate() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number.incrementAndGet();
    }
}

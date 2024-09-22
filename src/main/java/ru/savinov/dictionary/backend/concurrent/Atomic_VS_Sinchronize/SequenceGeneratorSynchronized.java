package ru.savinov.dictionary.backend.concurrent.Atomic_VS_Sinchronize;

public class SequenceGeneratorSynchronized implements Generatorable {
    private int number;

    public synchronized int generate() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number++;
    }
}

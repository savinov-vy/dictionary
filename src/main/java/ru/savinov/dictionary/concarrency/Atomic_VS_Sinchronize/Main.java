package ru.savinov.dictionary.concarrency.Atomic_VS_Sinchronize;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SequenceGeneratorSynchronized sequenceGenerator = new SequenceGeneratorSynchronized();
        SequenceGeneratorAtomic sequenceGeneratorAtomic = new SequenceGeneratorAtomic();
        execute(sequenceGeneratorAtomic, "ATOMIC");
        Thread.sleep(10000);
        execute(sequenceGenerator, "SYNCH");
    }

    private static void execute(Generatorable sequenceGenerator, String generatorName) {
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(generatorName + Thread.currentThread().getName() + " " + sequenceGenerator.generate());
                }
            }).start();
        }
    }
}

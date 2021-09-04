package ru.savinov.dictionary.backend.theoryCore.concarrency.Atomic_VS_Sinchronize;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SequenceGeneratorSynchronized sequenceGenerator = new SequenceGeneratorSynchronized();
        SequenceGeneratorAtomic sequenceGeneratorAtomic = new SequenceGeneratorAtomic();
        System.out.println("Атомики выполняют быстро");
        execute(sequenceGeneratorAtomic, "ATOMIC");
        Thread.sleep(1000);
        System.out.println("Через синхронизованный блок долго");
        execute(sequenceGenerator, "SYNCH");
    }

    private static void execute(Generatorable sequenceGenerator, String generatorName) {
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(generatorName
                            + Thread.currentThread().getName() +
                            " " + sequenceGenerator.generate());
                }
            }).start();
        }
    }
}

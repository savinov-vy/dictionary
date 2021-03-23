package ru.savinov.dictionary.theoryCore.ENUM.trainingDebag;

import ru.savinov.dictionary.theoryCore.ENUM.trainingDebag.package1.Put1;
import ru.savinov.dictionary.theoryCore.ENUM.trainingDebag.package1.Put2;

import java.util.HashMap;

public class Test_debag {
    public static void main(String[] args) throws InterruptedException {
        Test_debag test_debag = new Test_debag();
        Thread.sleep(3000);
        Put1 put1 = new Put1();
        Put2 put2 = new Put2();
        Put2 put21 = new Put2();
        ru.savinov.dictionary.theoryCore.ENUM.trainingDebag.package2.Put1 put = new ru.savinov.dictionary.theoryCore.ENUM.trainingDebag.package2.Put1();
        ru.savinov.dictionary.theoryCore.ENUM.trainingDebag.package2.Put1 put22 = new ru.savinov.dictionary.theoryCore.ENUM.trainingDebag.package2.Put1();
        ru.savinov.dictionary.theoryCore.ENUM.trainingDebag.package2.Put1 put23 = new ru.savinov.dictionary.theoryCore.ENUM.trainingDebag.package2.Put1();
        put21.PutIn();
        put.PutIn();
        put1.PutIn();
        put2.PutIn();
        put22.PutIn();
        put23.PutIn();

    }

    private HashMap<String, Object> map = new HashMap<>();

    public void setNumMap(String str, Object obj) {
        map.put(str, obj);
    }

    public void setStringMap(String str, Object obj) {
        map.put(str, obj);
    }

    public void setDateMap(String str, Object obj) {
        map.put(str, obj);
    }

}

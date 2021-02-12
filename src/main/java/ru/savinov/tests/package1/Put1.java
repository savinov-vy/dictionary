package ru.savinov.tests.package1;

import ru.savinov.tests.Test_debag;

public class Put1 {
    int a = 352;

    public void PutIn() {
        Test_debag test = new Test_debag();
        test.setNumMap("число1", a);
        test.setNumMap("число2", 4646);
        test.setNumMap("число3", 5464);
        test.setNumMap("число4", 999);
        test.setNumMap("число5", 5464);
        test.setNumMap("число6", 454);
    }
}

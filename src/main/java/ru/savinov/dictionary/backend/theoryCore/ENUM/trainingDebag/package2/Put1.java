package ru.savinov.dictionary.backend.theoryCore.ENUM.trainingDebag.package2;

import ru.savinov.dictionary.backend.theoryCore.ENUM.trainingDebag.Test_debag;

import java.util.Calendar;

public class Put1 {
    Calendar date = Calendar.getInstance();

    public void PutIn() {
        Test_debag test = new Test_debag();
        test.setNumMap("дата1", date);
        test.setNumMap("дата2", Calendar.getInstance());
        test.setNumMap("дата3", Calendar.getInstance());
        test.setNumMap("дата4", Calendar.getInstance());
    }
}

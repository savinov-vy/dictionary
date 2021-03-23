package ru.savinov.dictionary.theoryCore.ENUM;
// если объект типа WeekDays будет 1 # THURSDAY (остальные дни удалить) то это будет синглтон типа WeedDaysу.
public enum WeekDays {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    int numberOfDay;

    WeekDays(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }
}

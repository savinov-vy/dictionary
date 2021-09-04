package ru.savinov.dictionary.backend.theoryCore.ENUM;

public class TestWeekDaysENUM {
    public static void main(String[] args) {
        System.out.println(WeekDays.SUNDAY.getNumberOfDay());
        System.out.println("установим для воскресенья значение 9");
        WeekDays.SUNDAY.setNumberOfDay(9);
        System.out.println(WeekDays.SUNDAY.getNumberOfDay());
        System.out.println("получим значение enum из строки для среды");
        WeekDays wednesday = WeekDays.valueOf("WEDNESDAY");
        System.out.println(wednesday.getNumberOfDay());
    }
}

package ru.savinov.dictionary.docker.task_game;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * Реализуйте метод dailyTemperatures
     */
    public static List<Integer> dailyTemperatures(List<Integer> t) {
        Integer temToday;
        List<Integer> dayWaitUpTemp = new ArrayList<>();
        for (int i = 0; i < t.size(); i++) {
            Integer countDayToUpTemp = 1;
            temToday = t.get(i);
            if (i == (t.size() - 1)) {
                dayWaitUpTemp.add(0);
                break;
            }
            for (int j = i + 1; j < t.size(); j++) {
                if (temToday >= t.get(j)) {
                    countDayToUpTemp++;
                } else {
                    dayWaitUpTemp.add(countDayToUpTemp);
                    break;
                }
                if (j == (t.size() - 1)) {
                    dayWaitUpTemp.add(0);
                    break;
                }
            }
        }
        return dayWaitUpTemp;
    }

    public static void runCode() {
        // Данный метод будет вызван из метода main
        // Вы можете писать здесь произвольный код для дебага вашего кода
        // T = [73, 74, 75, 71, 69, 72, 76, 73]
        //daysNumber( T ) --> [1, 1,  4,  2,  1,   1,  0,  0]
                             //77, 76, 75, 74, 75, 76
                             // 0   0   3   1   1   0
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(73);
        list.add(74);
        list.add(75);
        list.add(71);
        list.add(69);
        list.add(72);
        list.add(76);
        list.add(73);
        System.out.println(dailyTemperatures(list));
        list2.add(77);
        list2.add(76);
        list2.add(74);
        list2.add(75);
        list2.add(76);
        System.out.println(dailyTemperatures(list2));
    }

    public static void main(String[] args) {
        runCode();
    }
}

package ru.savinov.dictionary.backend.algorithms.points.lines;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Задание:
 * По данным n отрезкам необходимо найти множество точек минимального размера, для которого каждый из отрезков содержит хотя бы одну из точек.
 * Формат входных данных:
 * Первая строка - количество отрезков
 * Последующие строки - координаты начала и конца отрезка, разделенные пробелом
 * Формат выходных данных:
 * Первая строка - количество найденных точек
 * Вторая строка - найденные точки, разделенные пробелом
 *
 * PS: существуют группы пересекающихся отрезков на каждую группу должна быть точка входящая в максимальное количество
 * отрезков. Найти для каждой группы такую точку которая входит во все отрезки.
 *
 * EXAMPLE_1
 * Sample Input 1:
 * 3
 * 1 3
 * 2 5
 * 3 6
 * Sample Output 1:
 * 1
 * 3
 * <p>
 * EXAMPLE_2
 * Sample Input 2:
 * 4
 * 4 7
 * 1 3
 * 2 5
 * 5 6
 * Sample Output 2:
 * 2
 * 3 6
 * <p>
 * <p>
 * Решение:
 * Взять не пересекающиеся отрезки:
 * Взять самый левый отрезок
 * проверять количество вохождений отрезков в каждую его точку в точке где количество начнёт снижаться эта
 * точка имеет максимальное количество вхдений
 * далее взять следующую самый левый отрезок
 *
 */
public class Points {

    public static void main(String[] args) throws FileNotFoundException {
        String PATH_TO_FILE = "src/main/java/ru/savinov/dictionary/backend/algorithms/points/lines/source.txt";
        Scanner sc = new Scanner(new FileReader(PATH_TO_FILE));
        int amountLines = Integer.parseInt(sc.nextLine());
        List<Line> stackLines = new ArrayList<>(amountLines);

        fillStackLines(stackLines, sc);
        stackLines.sort((Comparator.comparing(Line::getLeftBorder)));
        Line leftLine = stackLines.get(0);
        Collections.sort(stackLines);

        System.out.println(stackLines);

    }

    private static void fillStackLines(List<Line> stackLines, Scanner sc) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            List<Integer> borders = Arrays.stream(line.split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            stackLines.add(new Line(borders));
        }
    }

    static class Line implements Comparable<Line> {
        private final Integer leftBorder;
        private final Integer rightBorder;

        public Line(List<Integer> borders) {
            this.leftBorder = borders.get(0);
            this.rightBorder = borders.get(1);
        }

        public Integer getLeftBorder() {
            return leftBorder;
        }

        public Integer getRightBorder() {
            return rightBorder;
        }

        @Override
        public int compareTo(Line o) {
            if (this.rightBorder > o.rightBorder)
                return 1;
            else if (this.rightBorder < o.rightBorder) {
                return -1;
            } else return 0;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "leftBorder=" + leftBorder +
                    ", rightBorder=" + rightBorder +
                    '}';
        }
    }

}

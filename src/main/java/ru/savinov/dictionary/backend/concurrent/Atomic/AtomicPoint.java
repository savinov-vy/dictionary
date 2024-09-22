package ru.savinov.dictionary.backend.concurrent.Atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * задаче на одновременное атомарное изменение более чем двух параметров
 * существует точка в двумерной плоскости, её нужно повернуть по часовой стрелки
 *
 * создаётся неизменяемая копия объекта
 */
public class AtomicPoint {

    private final AtomicReference<Point> pt = new AtomicReference<>(new Point(0, 1));

    /**
     * AtomicReference - работает со ссылочными переменными имеет метод updateAndGet, который внутри имеет cast цикл
     * с помощью этого метода меняется один объект на другой. Таким образом внутри неизменяемого объекта создаётся
     * метод по подмене одного ссылочного неизменяемого объекта на другой. И с помощью updateAndGet один объект
     * подменяется на другой
     *
     * класс Point приватный и поля не изменяемые. Т.к. поля final они обязательно инициализируются в конструкторе
     * даже когда поля инициализируются по умолчанию так же поля инициализируются в конструкторе по умолчанию.
     */

    public  void rotateClockwise() {
        pt.updateAndGet(Point::rotateClockWise);
    }

    private static class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point rotateClockWise() {
            return new Point(y, -x);
        }
    }

    public static void main(String[] args) {

    }
}



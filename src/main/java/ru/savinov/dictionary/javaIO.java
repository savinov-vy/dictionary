package ru.savinov.dictionary;

import java.io.*;

public class javaIO {
    public static void main(String[] args) {
        //класс File - абстрактная репрезентация (абстрактный адрес) пути к файлу. Вне зависимости существует это файл или нет
        //нет никакой проблемы так написать. Не компилятор не рантайм машина не проверяет истинность cуществует этот файл или
        // нет (абстрактная репрезентация переменной f на путь к файлу test10.txh

        // FileInputStream - предназначен для создания потока, с помощью которого можно читать информацию из источника
        // сам поток не запускается создается только объект между файлом и программой (мост)
        // FileOutputStream предназначен для создания потока, с помощью которого можно писать информацию в источник


        File f = new File("test10.txt");

        try {
            FileInputStream fis = new FileInputStream(f);
            fis.read(); // запуск потока на получение информации
        } catch (IOException e) {
            System.out.println("Файл отстутсвует или поток прерван чтение не удалось");
        }

        try {
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(100);
        } catch (IOException e) {
            System.out.println("Файл отстутсвует или поток прерван запись не удалась");
        }
    }
}

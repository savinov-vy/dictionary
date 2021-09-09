package ru.savinov.dictionary.backend.regexp;

public class Methods {
    public static void main(String[] args) {

        // разбить строку в массив
        String a = "Hello8888there8965hey";
        String[] words = a.split("\\d");
        System.out.println(words);

        // найти и заменить по строке
        String b = "Hello there hey";
        String modifyingStr = b.replace(" ", ",");
       // b.replaceAll(); //принимает вместо строки регулярные выражения
    }
}

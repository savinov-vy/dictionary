package ru.savinov.dictionary.streamAPI.files;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * С помощью стрима можно обрабатывать строковые объекты из файлов
 */
public class FilesLine {
    public static void main(String[] args) throws IOException, URISyntaxException {

        /**
         * для подсчета символов в строке (обработка пути для linux)
         * строки можно обрабатывать и другим образом испопользуя стримы
         */
        Files.lines(Paths.get("/home/naglezh/IdeaProjects/dictionary/src/main/java/ru/savinov/dictionary/streamAPI/files/123.txt"))
                .map(String::length)
                .forEach(System.out::println);


    /**
     * Валидация количества открытых и закрытых строк через стрим. Для того чтобы пробросить
     * переменную в stream необходимо запихать её в mutable объект
     */

        String str = "())";
        Integer count = 0;
        int[] countBox = {count};
        str.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(ch -> {
                    if (ch == '(') {
                        countBox[0] = countBox[0] + 1;
                    }
                    if (ch == ')') {
                        countBox[0] = countBox[0] - 1;
                    }
                    if (countBox[0] < 0) System.out.println("строка не валидна");
                });
        if (countBox[0] != 0) {
            System.out.println("строка не валидна");
        } else System.out.println("строка валидна");

    }
}

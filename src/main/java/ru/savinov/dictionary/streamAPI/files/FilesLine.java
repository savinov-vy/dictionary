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
         * для подсчета напрсимволов в строке (обработка пути для linux)
         * строки можно обрабатывать и другим образом испопользуя стримы
         */
        Files.lines(Paths.get("/home/naglezh/IdeaProjects/dictionary/src/main/java/ru/savinov/dictionary/streamAPI/files/123.txt"))
                .map(String::length)
                .forEach(System.out::println);
    }
}

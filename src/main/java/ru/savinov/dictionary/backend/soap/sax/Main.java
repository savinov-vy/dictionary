package ru.savinov.dictionary.backend.soap.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File file = new File("/home/naglezh/IdeaProjects/dictionary/src/main/java" +
                "/ru/savinov/dictionary/backend/soap/sax/country.xml");

        if (file.exists()) {
            parser.parse(file, new MyHandler());
        }
    }
}

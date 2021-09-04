package ru.savinov.dictionary.backend.streamAPI.buratinoFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BuratinoFactory {
    public BuratinoFactory() {
    }

    public static void main(String[] args) {
        BuratinoFactory main = new BuratinoFactory();
        List<Buratino> listBuratino = main.createAndFillListBuratino();
        /** отфильтровать всех у кого есть книга*/
        List<Buratino> books = listBuratino.stream()
                .filter((b) -> b.properties.containsKey("Book"))
                .collect(Collectors.toList());

        /**есть ли деньги у любого Буратино из списка*/
        boolean has = listBuratino.stream().anyMatch((b -> b.properties.containsKey("Money")));
        System.out.println(has);

        /**
         * преобразовать поток Буратино в поток книг
         */
        List<Book> bookList = listBuratino.stream().map(new Function<Buratino, Book>() {
            @Override
            public Book apply(Buratino buratino) {
                return (Book) buratino.properties.get("Book");
            }
        }).collect(Collectors.toList());
        System.out.println(bookList);
    }

    private List<Buratino> createAndFillListBuratino() {
        int countBuratino = (int) (Math.random() * 100);
        List<Buratino> listBuratino = new ArrayList<>();
        for (int i = 0; i < countBuratino; i++) {
            Buratino buratino = new Buratino();
            buratino.setName("Буратино " + ++i);
            buratino.fillPropertiesBuratino();
            listBuratino.add(buratino);
        }
        return listBuratino;
    }


    private class Buratino {
        private HashMap<String, Object> properties = new HashMap<>();

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getProperties() {
            return properties;
        }

        public void setProperties(String key, Object properties) {
            this.properties.put(key, properties);
        }

        public void deletePropertiesByNuberProperty(Integer num) {
            List<String> propertiesKeyList = new ArrayList<>(properties.keySet());
            String deleteProperties = propertiesKeyList.get(num);
            this.properties.remove(deleteProperties);
        }

        public void fillPropertiesBuratino() {
            this.setProperties("Book", new Book());
            this.setProperties("Money", new Money());
            this.setProperties("Cap", new Cap());
            this.deletePropertiesByNuberProperty((int) (Math.random() * 3));
        }

        @Override
        public String toString() {
            return name +"{" +
                    "properties=" + properties +
                    '}';
        }
    }

    public class Book {
        String alphabet = "ABC";

        @Override
        public String toString() {
            return "Book{" +
                    "alphabet='" + alphabet + '\'' +
                    '}';
        }
    }

    public class Money {
        Integer money = new Random().ints(1,100).findFirst().getAsInt();

        @Override
        public String toString() {
            return "Money{" +
                    "money=" + money +
                    '}';
        }
    }

    public class Cap {
        Integer size = 3;

        @Override
        public String toString() {
            return "Cap{" +
                    "size=" + size +
                    '}';
        }
    }


}

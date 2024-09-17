package ru.savinov.dictionary.backend.theoryCore.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortedString {
    public static void main(String[] args) {
        var strings = new ArrayList<String>();

        Collections.addAll(strings, "JavaMustWin", "Supermarket", "Java Developer", "Liked");

        sortStringsByLength(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void sortStringsByLength(ArrayList<String> strings) {
        Collections.sort(strings, new StringComparator());
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}


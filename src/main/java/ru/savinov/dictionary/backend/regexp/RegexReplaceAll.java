package ru.savinov.dictionary.backend.regexp;

public class RegexReplaceAll {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
        System.out.println(changePath1(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        return path.replaceAll("jdk.*(?=/)", jdk);
    }

    public static String changePath1(String path, String jdk) {
        return path.replaceAll("jdk[^/]*", jdk);
    }
}

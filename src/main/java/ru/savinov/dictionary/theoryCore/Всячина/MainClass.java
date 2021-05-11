package ru.savinov.dictionary.theoryCore.Всячина;

public class MainClass {
    public static void main(String[] args) {

        String[] str = new String[2];
        str[0] = "aaa, bbb, ccc";
        str[1] = "ddd, eee";

        String[] str1 = new String[2];
        str[0] = "aaa, bbb, ccc";
        str[1] = "";

        String[] str2 = new String[2];
        str[0] = "";
        str[1] = "";
        joinString(str);


    }

    public static String joinString(String [] strings) {
        String result = null;
        if (strings[0] == null && strings[1] != null) {
        } else if (strings[0].equals("") && strings[1] != null) {

        } else if (strings[1] == null)
        else if(strings[1].equals(""))

    }
}

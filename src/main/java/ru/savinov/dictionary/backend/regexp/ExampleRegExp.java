package ru.savinov.dictionary.backend.regexp;

public class ExampleRegExp {
    public static void main(String[] args) {
        String str = "qwer";
        System.out.println(str.matches("qwer")); //true
        String str1 = "qwer";
        System.out.println(str.matches("qwe")); //false
/*            \\d - одна цифра
              \\w - одна английская буква
              \\w = [a-zA-Z]
*              * - ноль или более                                   например  \\d+   =   : 896
*              + - одна или более                                   например \\d*  = 8 : 896
*              ? - символ перед ним может быть а может не быть      например -?\\d+  минус перед числом есть или нет
*              ( |  | ) - описываются вероятные символы через или   например  (-|\\+)?\\d+ минус или плюс есть или нет перед числом длинны более одного символа. две косые черты перед + потому как + специальный символ
*              [a-zA-Z] - любой латинский символ                    например [a-zA-Z]\\d+  одна любая латинская буква и цифры G116151651
*                                                                   например [a-zA-Z]+\\d+  одна или более латинских букв и одна или более цифр ASsfs2591
*              [^adc] - кроме abc
*              String s = "hello";
*              System.out.println(s.matches([^adc]*)) любое количество символов кроме abc, hello не содержит a|b|c следовательно true
*              String s1 = "heallo";
*              System.out.println(s1.matches([^adc]*)) s1 содержит a следовательно false
*
*
*                       . - любой символ например валидация домена сайта String url = "http://www.google.com";
*                                                      System.out.println(url.matches("http://www\\..+\\.(com|ru)"));   \\ косые черты экранируют спецсимвол

*                   {2} - до 2х символов например \\d{2}   это 9  или 85
*                   {2,} - 2 или более символа     \\d{2,}  это 42 или 646428585
*                   {2, 4} - от 2х до 4х символов  [a-zA-Z]{}
*              + - одна или более   \\d*  = 8 : 896
*              + - одна или более   \\d*  = 8 : 896
*
*
*/
    }
}

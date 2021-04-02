package by.antonsh.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
2) Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в
позиции 0
 */
public class Ex2 {
    public static void main(String[] args) {
        String text="Hello my the best friend!";
        String result=text.replaceAll("e", String.valueOf(text.charAt(0)));
        System.out.println(result);

    }
}

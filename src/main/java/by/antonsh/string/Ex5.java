package by.antonsh.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
1) Найти в строке не только запятые, но и другие знаки препинания.Подсчитать общее их количество
 */
public class Ex5 {
    public static void main(String[] args) {
        String text = "Если в предложении присутствует слово-палиндром," +
                " то не имеет значения какое кол-во слов в предложении," +
                "оно попадает в новый файл.Пишем все в \"ООП\" стиле. " +
                "Создаём класс TextFormater в котором два статических метода:";
        Pattern pattern=Pattern.compile("[?.,:!\"']");
        Matcher matcher= pattern.matcher(text);
        int count=0;
        while(matcher.find()){
            System.out.print(matcher.group()+" ");
            count++;
        }
        System.out.println("\n------------------------");
        System.out.println("Итого - "+count);
    }
}

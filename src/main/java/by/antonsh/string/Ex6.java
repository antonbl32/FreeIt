package by.antonsh.string;

import java.util.Arrays;

/*
Имеется строка с текстом. Вывести текст, составленный из последних букввсех слов
 */
public class Ex6 {
    public static void main(String[] args) {
        String text = "Если в предложении присутствует слово-палиндром," +
                " то не имеет значения какое кол-во слов в предложении," +
                "оно попадает в новый файл.Пишем все в \"ООП\" стиле. " +
                "Создаём класс TextFormater в котором два статических метода:";
        String[] textWithoutMarks=text.split("[?.,:\"]");
        Arrays.stream(textWithoutMarks).forEach(a-> System.out.println(a.substring(a.length()-1)));
    }


}

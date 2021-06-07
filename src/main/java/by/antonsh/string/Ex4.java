package by.antonsh.string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
4)Текстовый файл содержит текст.
После запуска программы в другой файл должны записаться только те предложения в которых от 3-х до 5-ти слов.
Если в предложении присутствует слово-палиндром, то не имеет значения какое кол-во слов в предложении,
оно попадает в новый файл.Пишем все в ООП стиле. Создаём класс TextFormater в котором два статических метода:
1. Метод принимает строку и возвращает кол-во слов в строке.
2. Метод принимает строку и проверяет есть ли в строке слово-палиндром.
Если есть возвращает true, если нет false.
В main считываем файл.
Разбиваем текст на предложения. Используя методы класса TextFormater определяем подходит ли нам предложение.
Если подходит добавляем его в новый файл
 */
public class Ex4 {
    public static void main(String[] args) throws IOException {
        String path = "D:/polydrom.txt";
        String pathOut = "D:/outPut.txt";
        String text = new String(Files.readAllBytes(Paths.get(path)));
        List<String> listOfSentences = new ArrayList<>();
        listOfSentences.addAll(Arrays.stream(text.split("(?<=[.?!])")).collect(Collectors.toList()));
        System.out.println(listOfSentences);
        StringBuilder resultToWrite = new StringBuilder();
        for (int i = 0; i < listOfSentences.size(); i++) {
            if (TextFormatter.getNumberOfWordsInString(listOfSentences.get(i)) >= 3
                    && TextFormatter.getNumberOfWordsInString(listOfSentences.get(i)) <= 5
                    || TextFormatter.isPolychrome(listOfSentences.get(i))) {
                System.out.println(listOfSentences.get(i) + " ");
            }
        }
        Files.write(Paths.get(pathOut), Collections.singleton(resultToWrite), new StandardOpenOption[]{StandardOpenOption.CREATE});
        System.out.println("---------------------------------------");
        System.out.println(resultToWrite);
    }
}

class TextFormatter {
    public static int getNumberOfWordsInString(String str) {
        String[] newStr = str.trim().split(" ");
        return newStr.length;
    }

    public static boolean isPolychrome(String s) {
        return s.equalsIgnoreCase(
                new StringBuilder(
                        s).reverse().toString());
    }
}

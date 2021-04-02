package by.antonsh.string;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
3)В исходном файле находятся слова, каждое слово на новой стороке. Послезапуска программы должен создать файл, который будет содержать в себе только полиндромы
 */
public class Ex3 {
    public static void main(String[] args) throws IOException {
        String path = "D:/polydrom.txt";
        String[] array = Files.lines(Paths.get(path), StandardCharsets.UTF_8).toArray(String[]::new);
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(
                    new StringBuilder(
                            array[i]).reverse().toString())) {
                System.out.println(array[i] + " polydrom");
            }
        }

    }
}

package by.antonsh.stream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Задать массив чисел. Используя средства Stream API вывести на консоль нечетные
значения
 */
public class Ex4 {
    public static void main(String[] args) {
        List<Integer> list= Stream.generate(new Random()::nextInt).limit(10).collect(Collectors.toList());
        list.stream().filter(u->u%2!=0).forEach(System.out::println);
    }
}

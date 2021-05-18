package by.antonsh.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.stream.Collectors;

/*
Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
Найти самую высокую оценку с использованием итератора.
 */
public class Ex31 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> grade = new ArrayList<>(random.ints(15, 3, 10)
                .boxed().collect(Collectors.toList()));
        System.out.println(grade);
        ListIterator<Integer> iterator = grade.listIterator();
        Integer max = iterator.next();
        while (iterator.hasNext()) {
            if (iterator.next() > max) {
                iterator.previous();
                max = iterator.next();
            }
        }
        System.out.println("Max grade: " + max);
    }
}

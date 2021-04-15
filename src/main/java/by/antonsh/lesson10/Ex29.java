package by.antonsh.lesson10;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.stream.Collectors;

/*
Создать список оценок учеников с помощью ArrayList,
заполнить рандом. Удалить неудовлетворительные оценки
 */
public class Ex29 {
    public static void main(String[] args) {
        Random random=new Random();
        ArrayList<Integer> grade=new ArrayList<Integer>(
                random.ints(15,3,10).boxed().collect(Collectors.toList()));
        System.out.println(grade);
        grade= (ArrayList<Integer>) grade.stream().filter(a->a>=7).collect(Collectors.toList());
        System.out.println(grade);
    }
}

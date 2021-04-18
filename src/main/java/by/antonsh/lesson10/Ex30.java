package by.antonsh.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
Создать рандомную коллекцию чисел, удалить повторяющиеся
 */
public class Ex30 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>(random.ints(15, 3, 10)
                .boxed().collect(Collectors.toList()));
        System.out.println(list);
        list =list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
    }
}

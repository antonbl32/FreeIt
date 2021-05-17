package by.antonsh.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/*
Задать массив строк. Используя средства Stream API отсортировать строки в
лексикографическом порядке по возрастанию и убыванию
 */
public class Ex2 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("Tima","Mike","Arsen","Kate");
        List<String> list2=list.stream().sorted().collect(Collectors.toList());
        List<String> list3=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}

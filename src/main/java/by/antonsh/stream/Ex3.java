package by.antonsh.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/*
Задать массив строк. Используя средства Stream API определить количество
уникальных значений.
 */
public class Ex3 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("Tima","Mike","Arsen","Arsen","Kate");
        Long count =list.stream().distinct().count();
    }
}

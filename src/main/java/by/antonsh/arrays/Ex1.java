package by.antonsh.arrays;

import java.util.Arrays;
/*
Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы
массива на экран сначала в строку, отделяя один элемент от другого пробелом, а
затем в столбик (отделяя один элемент от другого началом новой строки). Перед
созданием массива подумайте, какого он будет размера.
 */

public class Ex1 {
    public static void main(String[] args) {

        int[] randomArray = new int[10];
        for (int i = 0; i < 10; i++) {
            randomArray[i] = i * 2;
        }
        Arrays.stream(randomArray).forEach(a -> System.out.print(a + " "));
        System.out.println();
        System.out.println("-------------------------");
        Arrays.stream(randomArray).forEach(System.out::println);

    }
}

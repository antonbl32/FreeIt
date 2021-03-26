package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Random;
/*
Создайте массив из 4 случайных целых чисел из отрезка [0;10], выведите его
на экран в строку. Определить и вывести на экран сообщение о том, является ли
массив строго возрастающей последовательностью.
 */
public class Ex6 {
    public static void main(String[] args) {
        int[] array;
        Random random = new Random();
        array = random.ints(5, 0, 10).toArray();
        int[] arraySorted= Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arraySorted));
        if(Arrays.equals(array,arraySorted)){
            System.out.println("Массив отсортирован");

        }else {
            System.out.println("Массив не отсортирован");
        }
    }
}

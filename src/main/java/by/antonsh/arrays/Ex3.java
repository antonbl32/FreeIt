package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Random;
/*
Создайте массив из 15 случайных целых чисел из отрезка [0; 99]. Выведите
массив на экран. Подсчитайте сколько в массиве чётных элементов и выведете
это количество на экран на отдельной строке.
 */
public class Ex3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[15];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(99);
        }
        System.out.println(Arrays.toString(array));
        Arrays.stream(array).filter(a -> a % 2 == 0 && a > 0).forEach(a -> System.out.print(a + "  "));
        System.out.println();
        System.out.println("Четных чисел в массиве " + Arrays.stream(array).filter(a -> a % 2 == 0 && a > 0).count());
    }
}

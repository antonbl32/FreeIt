package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/*
Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в
строку, а затем этот же массив выведите на экран тоже в строку, но в обратном
порядке (99 97 95 93 … 7 5 3 1)
 */
public class Ex2 {
    public static void main(String[] args) {
        // For use Arrays.sort need Integer object, not primitives
        Integer[] array = new Integer[50];
        int key = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                array[key] = i;
                key++;
            }

        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, Comparator.reverseOrder());
        System.out.println(Arrays.toString(array));
    }
}

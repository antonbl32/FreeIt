package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/*
Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в
строку, а затем этот же массив выведите на экран тоже в строку, но в обратном
порядке (99 97 95 93 … 7 5 3 1)
 */
public class Ex2 {
    public static void main(String[] args) {
        int[] noEvenArray = Stream.iterate(1, a -> a + 1)
                .limit(99).filter(a -> a != 0 && a % 2 > 0)
                .mapToInt(n -> n).toArray();
        System.out.println(Arrays.toString(noEvenArray));
        int[] reverseArray = Arrays.stream(noEvenArray).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(reverseArray));
    }
}

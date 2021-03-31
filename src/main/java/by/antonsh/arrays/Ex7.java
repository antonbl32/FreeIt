package by.antonsh.arrays;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

/*
Создайте массив из 12 случайных целых чисел из отрезка [0;15]. Определите
какой элемент является в этом массиве максимальным и сообщите индекс его
последнего вхождения в массив.
 */
public class Ex7 {
    public static void main(String[] args) {
        int[] array;
        Random random = new Random();
        array = random.ints(12, 0, 15).toArray();
        System.out.println(Arrays.toString(array));
        OptionalInt max = Arrays.stream(array).max();
        if (max.isPresent()) {
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                if (max.getAsInt() == array[i]) {
                    index = i;
//                    break; for the last match
                }
            }
            System.out.println("Максимальное значение " + max.getAsInt()
                    + " индекс " + index);
        }
    }
}

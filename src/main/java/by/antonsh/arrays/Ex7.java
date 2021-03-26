package by.antonsh.arrays;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

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
                    break;
                }
            }
            System.out.println("Максимальное значение " + max.getAsInt()
                    + " индекс " + index);
        }
    }
}

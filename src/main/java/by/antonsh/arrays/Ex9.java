package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        System.out.println("Введите целое положительное число.");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Введите положительное целое число!");
                scanner.next();
            }
            length = scanner.nextInt();
        } while (length <= 1);
        int[] array;
        Random random = new Random();
        array = random.ints(length, 0, 15).toArray();
        System.out.println("Массив " + Arrays.toString(array));
        int[] firstHalf = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
        int sumFirst = Arrays.stream(firstHalf).sum();
        int sumSecond = Arrays.stream(secondHalf).sum();
        if (sumFirst > sumSecond) {
            System.out.println("Сумма первого массива больше");
        } else if (sumFirst < sumSecond) {
            System.out.println("Сумма второго массива больше");
        } else {
            System.out.println("Суммы массивов равны");
        }

    }
}

package by.antonsh.arrays;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Random;

/*
Создайте 2 массива из 5 случайных целых чисел из отрезка [0;15] каждый,
выведите массивы на экран в двух отдельных строках. Посчитайте среднее
арифметическое элементов каждого массива и сообщите, для какого из
массивов это значение оказалось больше (либо сообщите, что их средние
арифметические равны).
 */
public class Ex5 {
    public static void main(String[] args) {
        int[] arrayFirst;
        Random random = new Random();
        arrayFirst = random.ints(5, 0, 15).toArray();
        int[] arraySecond;
        arraySecond = random.ints(5, 0, 15).toArray();
        System.out.println(Arrays.toString(arrayFirst));
        System.out.println(Arrays.toString(arraySecond));
        OptionalDouble averageArrayFirst = Arrays.stream(arrayFirst).average();
        if (averageArrayFirst.isPresent()) {
            System.out.println("Среднее арифмитическое первого массива " + averageArrayFirst.getAsDouble());
        } else {
            System.out.println("Пустой массив");
        }
        OptionalDouble averageArraySecond = Arrays.stream(arraySecond).average();
        if (averageArraySecond.isPresent()) {
            System.out.println("Среднее арифмитическое второго массива " + averageArraySecond.getAsDouble());
        } else {
            System.out.println("Пустой массив");
        }
        if (averageArrayFirst.getAsDouble() > averageArraySecond.getAsDouble()) {
            System.out.println("Среднее арифметическое первого массива больше");
        } else if (averageArrayFirst.getAsDouble() < averageArraySecond.getAsDouble()) {
            System.out.println("Среднее арифметическое второго массива больше");
        } else {
            System.out.println("Среднее арифметическое обоих массивов равны");
        }
    }
}

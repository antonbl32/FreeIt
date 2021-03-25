package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;

public class Ex5 {
    public static void main(String[] args) {
        int[] arrayFirst;
        Random random = new Random();
        arrayFirst = random.ints(5, 0, 15).toArray();
        int[] arraySecond;
        arraySecond = random.ints(5, 0, 15).toArray();
        System.out.println(Arrays.toString(arrayFirst));
        System.out.println(Arrays.toString(arraySecond));
        OptionalDouble averageArrayFirst=Arrays.stream(arrayFirst).average();
        if(averageArrayFirst.isPresent()){
            System.out.println("Среднее арифмитическое первого массива " + averageArrayFirst.getAsDouble());
        }else {
            System.out.println("Пустой массив");
        }
        OptionalDouble averageArraySecond=Arrays.stream(arraySecond).average();
        if(averageArraySecond.isPresent()){
            System.out.println("Среднее арифмитическое первого массива " + averageArraySecond.getAsDouble());
        }else {
            System.out.println("Пустой массив");
        }
        if(averageArrayFirst.getAsDouble()>averageArraySecond.getAsDouble()){
            System.out.println("Больше первый массив");
        }else if(averageArrayFirst.getAsDouble()<averageArraySecond.getAsDouble()){
            System.out.println("Больше второй массив");
        }else{
            System.out.println("Массивы равны");
        }
    }
}

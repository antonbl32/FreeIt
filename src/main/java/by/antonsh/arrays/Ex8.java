package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Random;

/*
Создайте два массива из 10 целых случайных чисел из отрезка [0;9] и третий
массив из 10 действительных чисел. Каждый элемент с i-ым индексом третьего
массива должен равняться отношению элемента из первого массива с i-ым
индексом к элементу из второго массива с i-ым индексом. Вывести все три
массива на экран (каждый на отдельной строке), затем вывести количество
целых элементов в третьем массиве.
 */
public class Ex8 {
    public static void main(String[] args) {
        int[] arrayFirst;
        Random random = new Random();
        arrayFirst = random.ints(10, 0, 9).toArray();
        System.out.println(Arrays.toString(arrayFirst));
        int[] arraySecond;
        arraySecond = random.ints(10, 0, 9).toArray();
        System.out.println(Arrays.toString(arraySecond));
        double[] arrayResult = new double[10];
        for (int i = 0; i < arrayResult.length; i++) {
            try {
                arrayResult[i] = (double) arrayFirst[i] / arraySecond[i];
                if (Double.isNaN(arrayResult[i])) {
                    throw (new ArithmeticException("Exception. "));
                } else if (Double.isInfinite(arrayResult[i])) {
                    throw (new ArithmeticException("Exception. "));
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + "Было деление на ноль, присвоим 0");
                arrayResult[i] = 0;
            }
        }
        System.out.println("Получился массив: " + Arrays.toString(arrayResult));
        Arrays.stream(arrayResult).filter(a->Math.ceil(a)==a).forEach(System.out::println);
    }
}

package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Random;

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
    }
}

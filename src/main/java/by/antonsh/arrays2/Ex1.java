package by.antonsh.arrays2;

import java.util.Arrays;
import java.util.Random;

/*
 Найти произведение элементов, кратных 3.
 */
public class Ex1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arrayInts;
        arrayInts = random.ints(6, 0, 10).toArray();
        int result=1;

        System.out.println(Arrays.toString(arrayInts));
        for (int i = 0; i < arrayInts.length; i++) {
            if (arrayInts[i] % 3 == 0 && arrayInts[i]!=0) {
                result*=arrayInts[i];
            }
        }
        System.out.println(result);
        System.out.println("----------------------------------------------");
        /*
        2) Найти среднее арифметическое элементов с нечетными номерами
         */
        int secondResult=0;
        int countN=0;
        for (int i =0; i < arrayInts.length; i+=2) {
                secondResult+=arrayInts[i];
                System.out.print(" "+arrayInts[i]);
                countN++;

        }
        System.out.println();
        System.out.println((double) secondResult/countN);

    }
}

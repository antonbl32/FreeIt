package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Введите целое положительное число больше 3.");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Введите положительное целое число больше 3х!");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n < 3);
        int[] array;
        Random random = new Random();
        array = random.ints(n, 0, n).toArray();
        System.out.println("Массив " + Arrays.toString(array));
        int[] arrayResult;
        if(n%2>0){
            arrayResult = new int[array.length/2+1];
        }else{
            arrayResult = new int[array.length/2];
        }

        int count=0;
        if(array.length>1){
            for (int i = 0; i < array.length ; ++i) {
                if(i%2!=0){
                    arrayResult[count]=array[i];
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(arrayResult));
    }
}

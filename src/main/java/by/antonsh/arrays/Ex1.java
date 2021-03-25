package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {

        int[] randomArray=new int[10];
        for (int i = 0; i < 10; i++) {
            randomArray[i]=i*2;
        }
        Arrays.stream(randomArray).forEach(a-> System.out.print(a + " "));
        System.out.println();
        System.out.println("-------------------------");
        Arrays.stream(randomArray).forEach(System.out::println);
    }
}

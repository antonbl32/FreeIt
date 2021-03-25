package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Random;


public class Ex4 {
    public static void main(String[] args) {
        int[] array=new int[20];
        Random random=new Random();
        array=random.ints(20,0,20).toArray();
        System.out.println(Arrays.toString(array));
        Arrays.stream(array).forEach(a-> System.out.printf(" | %s",a));
        System.out.println(" |");
        for (int i = 0; i < array.length; i++) {
            if(i%2!=0){
                array[i]=0;
            }
        }
        Arrays.stream(array).forEach(a-> System.out.printf(" | %s",a));
        System.out.println(" |");
    }
}

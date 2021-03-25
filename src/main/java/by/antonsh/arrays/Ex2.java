package by.antonsh.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ex2 {
    public static void main(String[] args) {
        // For use Arrays.sort need Integer object, not primitives
        Integer[] array=new Integer[50];
        int key=0;
        for (int i = 1; i < 100; i++) {
            if(i%2!=0){
                array[key]=i;
                key++;
            }

        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array,Comparator.reverseOrder());
        System.out.println(Arrays.toString(array));
    }
}

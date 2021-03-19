package by.antonsh.lesson2;


import java.util.Arrays;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {

        String[] text={"","а","ов"};
        //для binarySearch должен быть отсортированный массив
        int[] withOf={0,5,6,7,8,9};
        int[] withA={2,3,4};
        Scanner sc=new Scanner(System.in);
        int prog=sc.nextInt();
        int prog2=prog%10;
        if(prog2==1){
            System.out.println(prog+" - программист"+text[0]);
            System.exit(0);
        }else if(Arrays.binarySearch(withOf,prog2)>=0){
            System.out.println(prog+" - программист"+text[2]);
            System.exit(0);
        }else if(Arrays.binarySearch(withA,prog2)>=0){
            System.out.println(prog+" - программист"+text[1]);
        }
    }

}

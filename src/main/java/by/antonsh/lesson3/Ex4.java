package by.antonsh.lesson3;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int pow=0;
        for (int i =0 ; i <b ; i++) {
            pow+=a;
            System.out.println("Iteration #"+i+" pow = "+pow);
        }
    }
}

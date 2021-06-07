package by.antonsh.lesson2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите сторону а: ");
        int a=sc.nextInt();
        System.out.println("Введите сторону b: ");
        int b=sc.nextInt();
        System.out.println("Введите сторону c: ");
        int c=sc.nextInt();
        if(a+b>c && a+c>b && c+b>a){
            System.out.println("Треугольник существует");
        }else{
            System.out.println("Треугольник НЕ существует");
        }
    }
}

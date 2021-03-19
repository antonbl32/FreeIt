package by.antonsh.lesson2;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double number1=sc.nextDouble();
        System.out.println("Введите второе число: ");
        double number2=sc.nextDouble();
        if(number1>number2){
            System.out.println(number1 + " больше, чем "+number2);
        }else if(number1==number2) {
            System.out.println(number1 + " равно "+number2);
        }else {
            System.out.println(number1 + " меньше, чем "+number2);
        }
    }
}

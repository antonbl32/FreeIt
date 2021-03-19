package by.antonsh.lesson2;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        // 1 способ используя String.length
        System.out.println("Введите число:");
        Scanner sc=new Scanner(System.in);
        int number;
        String forLen;
        String[] text={"одно-","двух-","трех-","четырех-"};
        while(!sc.hasNextDouble()){
            System.out.println("Введите число:");
            sc.next();
        }
        number=(int)sc.nextDouble();
        forLen=String.valueOf(Math.abs(number));
        if(number>=0){
            System.out.println("это "+text[forLen.length()-1]+"значное положительное число");
        }else{
            System.out.println("это "+text[forLen.length()-1]+"значное отрицательное число");
        }
        // 2 способ использует деление
        int count=0;
        int number2=number;
        if(number!=0){
            while(Math.abs(number2)>0){
                number2 /=10;
                count++;
            }
        }else{
            count++;
        }
        if(number>=0){
            System.out.println("это "+text[count-1]+"значное положительное число");
        }else{
            System.out.println("это "+text[count-1]+"значное отрицательное число");
        }
    }
}

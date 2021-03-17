package by.antonsh.lesson2;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("Введите число");
        Integer number=new Scanner(System.in).nextInt();
        if(number>0){
            number +=1;
        }else if(number==0){
            number=10;
        }else {
            number -=2;
        }
        System.out.println(number);
    }
}

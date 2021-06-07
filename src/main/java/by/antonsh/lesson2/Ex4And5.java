package by.antonsh.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4And5 {
    public static void main(String[] args) {
        //Для массива введенных значений
        Scanner sc=new Scanner(System.in);
        List<Integer> mass=new ArrayList<>();
        System.out.println("Для добавление введите число, для остановки ввода не число");
        while(sc.hasNextInt()){
            mass.add(sc.nextInt());
        }
        int plusCount=0;
        int minusCount=0;
        for (Integer i:mass
             ) {
            if (i>=0){
                plusCount++;
            }else{
                minusCount++;
            }
        }
        System.out.println("Положительных чисел "+plusCount+", отрицательных чисел "+minusCount);
    }
}

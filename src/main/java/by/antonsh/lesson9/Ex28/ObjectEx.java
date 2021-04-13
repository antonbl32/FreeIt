package by.antonsh.lesson9.Ex28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Написать класс, который умеет хранить в себе массив любых типов данных.
Реализовать метод get(int index), который возвращает любой элемент массива по индексу.
 */

/**
 * This class create Object array and fill it.
 */
public class ObjectEx {
    static Object[] array;

    public static void main(String[] args) {
        array = new Object[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            array[i] = sc.next();
            System.out.println(getItemWithIndex(i));
        }
    }

    static Object getItemWithIndex(int index) {
        return array[index];
    }
}

/**
 * This class have a generic arraylist
 * @param <T> - type of Object
 */
class GenericsEx <T>{
    private List<T> list=new ArrayList<>();

    public GenericsEx(List<T> list) {
        this.list = list;
    }

    public GenericsEx() {
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    public T getElementByIndex(int index){
        return list.get(index);
    }
}

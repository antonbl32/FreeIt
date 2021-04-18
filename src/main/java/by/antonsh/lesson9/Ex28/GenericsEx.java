package by.antonsh.lesson9.Ex28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Написать класс, который умеет хранить в себе массив любых типов данных.
Реализовать метод get(int index), который возвращает любой элемент массива по индексу.
 */

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

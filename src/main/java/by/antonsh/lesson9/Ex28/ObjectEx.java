package by.antonsh.lesson9.Ex28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

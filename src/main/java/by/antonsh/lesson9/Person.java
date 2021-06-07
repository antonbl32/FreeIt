package by.antonsh.lesson9;


import by.antonsh.lesson9.clothes.jacket.Jacket;
import by.antonsh.lesson9.clothes.pants.Pants;
import by.antonsh.lesson9.clothes.shoes.Shoes;

public class Person {
    private String name;
    private Jacket jacket;
    private Pants pants;
    private Shoes shoes;

    public Person(String name, Jacket jacket, Pants pants, Shoes shoes) {
        this.name = name;
        this.jacket = jacket;
        this.pants = pants;
        this.shoes = shoes;
    }

    public void dressOn() {
        System.out.println("Man " + name + " going to dress on");
        jacket.putOn();
        pants.putOn();
        shoes.putOn();
    }

    public void takeOff() {
        System.out.println("Man " + name + " going to take off");
        jacket.takeOff();
        pants.takeOff();
        shoes.takeOff();
    }
}

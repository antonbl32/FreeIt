package by.antonsh.lesson9.clothes.jacket;


import by.teachmeskills.clothes.pants.Pants;

public class ChinaJacketImpl implements Jacket {
    @Override
    public void putOn() {
        System.out.println("China jacket are putting on");
    }

    @Override
    public void takeOff() {
        System.out.println("China jacket are taking off");
    }
}

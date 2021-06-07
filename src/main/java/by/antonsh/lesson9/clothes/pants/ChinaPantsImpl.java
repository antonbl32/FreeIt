package by.antonsh.lesson9.clothes.pants;


public class ChinaPantsImpl implements Pants {
    @Override
    public void putOn() {
        System.out.println("China pants are putting on");
    }

    @Override
    public void takeOff() {
        System.out.println("China pants are taking off");
    }
}

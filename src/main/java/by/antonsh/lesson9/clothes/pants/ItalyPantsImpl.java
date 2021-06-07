package by.antonsh.lesson9.clothes.pants;

public class ItalyPantsImpl implements Pants {
    @Override
    public void putOn() {
        System.out.println("Italy pants are putting on");
    }

    @Override
    public void takeOff() {
        System.out.println("Italy pants are taking off");
    }
}

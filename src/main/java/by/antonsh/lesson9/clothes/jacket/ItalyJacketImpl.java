package by.antonsh.lesson9.clothes.jacket;


public class ItalyJacketImpl implements Jacket {
    @Override
    public void putOn() {
        System.out.println("Italy jacket are putting on");
    }

    @Override
    public void takeOff() {
        System.out.println("Italy jacket are taking off");
    }
}

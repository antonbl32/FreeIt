package by.antonsh.lesson9.clothes.shoes;

public class ItalyShoesImpl implements Shoes {
    @Override
    public void putOn() {
        System.out.println("Italy shoes are putting on");
    }

    @Override
    public void takeOff() {
        System.out.println("Italy shoes are taking off");
    }
}

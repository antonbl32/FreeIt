package by.antonsh.lesson9.clothes.shoes;

public class ChinaShoesImpl implements Shoes {
    @Override
    public void putOn() {
        System.out.println("China shoes are putting on");
    }

    @Override
    public void takeOff() {
        System.out.println("China shoes are taking off");
    }
}

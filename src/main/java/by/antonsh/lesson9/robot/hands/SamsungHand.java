package by.antonsh.lesson9.robot.hands;

public class SamsungHand implements IHand {
    private int price;

    public SamsungHand() {
    }

    public SamsungHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Samsung hands up!");
    }

    @Override
    public int getPrice() {
        return 0;
    }
}

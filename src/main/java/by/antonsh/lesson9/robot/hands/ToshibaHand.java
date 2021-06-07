package by.antonsh.lesson9.robot.hands;

public class ToshibaHand implements IHand {
    private int price;

    public ToshibaHand() {
    }

    public ToshibaHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Toshiba hands up!");
    }

    @Override
    public int getPrice() {
        return 0;
    }
}

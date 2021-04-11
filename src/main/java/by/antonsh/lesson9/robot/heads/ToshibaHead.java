package by.antonsh.lesson9.robot.heads;

public class ToshibaHead implements IHead {
    private int price;

    public ToshibaHead() {
    }

    public ToshibaHead(int price) {
        this.price = price;
    }

    @Override
    public void speek() {
        System.out.println("It's speak head of Toshiba");
    }

    @Override
    public int getPrice() {
        return price;
    }
}

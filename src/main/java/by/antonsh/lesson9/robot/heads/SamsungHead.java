package by.antonsh.lesson9.robot.heads;

public class SamsungHead implements IHead {
    private int price;

    public SamsungHead() {
    }

    public SamsungHead(int price) {
        this.price = price;
    }

    @Override
    public void speek() {
        System.out.println("It's speak head of Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}

package by.antonsh.lesson9.robot.legs;

public class SonyLeg implements ILeg {
    private int price;

    public SonyLeg() {
    }

    public SonyLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("One step by sony leg");
    }

    @Override
    public int getPrice() {
        return 0;
    }
}

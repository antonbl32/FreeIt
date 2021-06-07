package by.antonsh.lesson9.robot.legs;

public class ToshibaLeg implements ILeg {
    private int price;

    public ToshibaLeg() {
    }

    public ToshibaLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("One step by toshiba leg");
    }

    @Override
    public int getPrice() {
        return 0;
    }
}

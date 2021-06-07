package by.antonsh.lesson9.robot.legs;

public class SamsungLeg implements ILeg {
    private int price;

    public SamsungLeg() {
    }

    public SamsungLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("One step by samsung leg");
    }

    @Override
    public int getPrice() {
        return 0;
    }
}

package by.antonsh.lesson9.robot.hands;

import by.teachmeskills.robot.heads.IHead;

public class SonyHand implements IHand {
    private int price;

    public SonyHand() {
    }

    public SonyHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Sony hands up!");
    }

    @Override
    public int getPrice() {
        return 0;
    }
}

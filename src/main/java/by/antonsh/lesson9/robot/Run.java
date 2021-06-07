package by.antonsh.lesson9.robot;


import by.antonsh.lesson9.robot.hands.SamsungHand;
import by.antonsh.lesson9.robot.hands.SonyHand;
import by.antonsh.lesson9.robot.hands.ToshibaHand;
import by.antonsh.lesson9.robot.heads.SamsungHead;
import by.antonsh.lesson9.robot.heads.SonyHead;
import by.antonsh.lesson9.robot.legs.SonyLeg;
import by.antonsh.lesson9.robot.legs.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */
        Robot r1 = new Robot(new SamsungHead(10), new ToshibaHand(5), new SonyLeg(8));
        r1.action();
        Robot r2 = new Robot(new SonyHead(9), new SamsungHand(5), new SonyLeg(11));
        r2.action();
        Robot r3 = new Robot(new SamsungHead(10), new SonyHand(7), new ToshibaLeg(9));
        r3.action();
        if (r1.getPrice() > r2.getPrice() && r1.getPrice() > r3.getPrice()) {
            System.out.println("R1 the most expensive");
        } else if (r2.getPrice() > r1.getPrice() && r2.getPrice() > r3.getPrice()) {
            System.out.println("R2 the most expensive");
        } else {
            System.out.println("R3 the most expensive or some price equal");
        }
    }
}

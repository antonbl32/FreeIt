package by.teachmeskills.robot;

import by.teachmeskills.robot.hands.SamsungHand;
import by.teachmeskills.robot.hands.SonyHand;
import by.teachmeskills.robot.hands.ToshibaHand;
import by.teachmeskills.robot.heads.SamsungHead;
import by.teachmeskills.robot.heads.SonyHead;
import by.teachmeskills.robot.legs.SonyLeg;
import by.teachmeskills.robot.legs.ToshibaLeg;

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
        Robot r1=new Robot(new SamsungHead(10),new ToshibaHand(5),new SonyLeg(8));
        r1.action();
        Robot r2=new Robot(new SonyHead(9),new SamsungHand(5),new SonyLeg(11));
        r2.action();
        Robot r3=new Robot(new SamsungHead(10),new SonyHand(7),new ToshibaLeg(9));
        r3.action();
    }
}

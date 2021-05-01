package by.antonsh.concurrency.ex3;

import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/*
Автостоянка. Доступно несколько машиномест. На одном месте может
находиться только один автомобиль. Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую
стоянку.
 */
@NoArgsConstructor
public class AutoStop {
    private AtomicInteger freeSpace = new AtomicInteger(30);
    private Random random=new Random();
    public boolean getFreeSpace() {
        if (freeSpace.get() != 0) {
            System.out.println(Thread.currentThread().getName() + " стала на стоянку");
            freeSpace.decrementAndGet();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(random.nextBoolean()){
                freeSpace.incrementAndGet();
                System.out.println("Машина уехала со стоянки");
            }
            return true;
        } else {
            System.out.println("Все места заняты");
        }
        return false;
    }
}

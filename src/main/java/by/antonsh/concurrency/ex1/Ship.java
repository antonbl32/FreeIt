package by.antonsh.concurrency.ex1;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.Semaphore;

@Data
public class Ship implements Runnable {
    Random random = new Random();
    private final int MAXCONTAINER = random.nextInt(60) + 60;
    private int container = random.nextInt(60);
    private Semaphore semaphore;
    private Port port;

    public Ship(Semaphore semaphore, Port port) {
        this.semaphore = semaphore;
        this.port = port;
    }

    public void loadShip() {
        if ((MAXCONTAINER - container) <= port.getCountContainer().get()) {
            port.getCountContainer().set(port.getCountContainer().get() - (MAXCONTAINER - container));
            container = MAXCONTAINER;
            System.out.println("Port " + port.getCountContainer() + " containers");
            System.out.println("Корабль " + Thread.currentThread().getName() + " загрузился " + container);
        } else {
            System.out.println("Port " + port.getCountContainer() + " containers");
            System.out.println("Корабль " + Thread.currentThread().getName() + " не загрузился " + container);
        }
    }

    public void unloadShip() {
        if ((MAXCONTAINER - container) <= (port.getMAXCONTAINER() - port.getCountContainer().get())) {
            port.getCountContainer().set(port.getCountContainer().get() + (MAXCONTAINER - container));
            container = 0;
            System.out.println("Port " + port.getCountContainer() + " containers");
            System.out.println("Корабль " + Thread.currentThread().getName() + " выгрузился " + container);
        } else {
            System.out.println("Port " + port.getCountContainer() + " containers");
            System.out.println("Корабль " + Thread.currentThread().getName() + " не выгрузился " + container);
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Корабль " + Thread.currentThread().getName() + " ожидает");
            semaphore.acquire();
            System.out.println("Корабль " + Thread.currentThread().getName() + " на загрузке");
            if (random.nextBoolean()) {
                this.loadShip();
                Thread.sleep(100);
                this.unloadShip();
                Thread.sleep(100);
            } else {
                this.unloadShip();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

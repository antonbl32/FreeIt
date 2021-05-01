package by.antonsh.concurrency.ex3;

import lombok.Data;

@Data
public class Car implements Runnable {
    private AutoStop autoStop;

    public Car(AutoStop autoStop) {
        this.autoStop = autoStop;
    }

    @Override
    public void run() {
        if(!autoStop.getFreeSpace()){
            System.out.println(Thread.currentThread().getName()+" не нашла свободных мест.");
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

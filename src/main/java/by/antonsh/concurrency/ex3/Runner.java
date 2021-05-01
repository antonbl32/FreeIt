package by.antonsh.concurrency.ex3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Runner {
    public static void main(String[] args) {
        AutoStop autoStop = new AutoStop();
        AtomicInteger countName = new AtomicInteger(0);
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setName("Машина " + countName.incrementAndGet());
            return thread;
        };
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);
        for (int i = 0; i < 50; i++) {
            executorService.execute(new Car(autoStop));
        }
        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

package by.antonsh.concurrency.ex1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Runner {
    public static void main(String[] args) {
        Port port = new Port();
        AtomicInteger countName = new AtomicInteger(0);
        Semaphore semaphore = new Semaphore(port.getDOCKS(), true);
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setName(String.valueOf(countName.incrementAndGet()));
            return thread;
        };
        ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
        for (int i = 0; i < 40; i++) {
            executor.execute(new Ship(semaphore, port));
        }
        executor.shutdown();
    }
}

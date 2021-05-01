package by.antonsh.concurrency.ex2;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Runner {
    public static void main(String[] args) {
        Library library=new Library();
        AtomicInteger countName = new AtomicInteger(0);
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setName("Читатель "+countName.incrementAndGet());
            return thread;
        };
        ExecutorService executorService= Executors.newCachedThreadPool(threadFactory);
        for (int i = 0; i <26 ; i++) {
            executorService.execute(new Reader(library));
        }
        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

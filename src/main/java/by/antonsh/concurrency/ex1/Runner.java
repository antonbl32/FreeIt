package by.antonsh.concurrency.ex1;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {
        Port port=new Port();
        Semaphore semaphore=new Semaphore(port.getDOCKS());
        for (int i = 0; i <50 ; i++) {
            new Ship(semaphore,port);
        }
    }
}

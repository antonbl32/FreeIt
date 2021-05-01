package by.antonsh.concurrency.ex1;

import lombok.Data;
import java.util.concurrent.Semaphore;

@Data
public class Ship extends Thread {
    private final int MAXCONTAINER=50;
    private int container=50;
    private Semaphore semaphore;
    private Port port;
    public Ship(Semaphore semaphore,Port port){
        this.semaphore=semaphore;
        this.port=port;
        this.start();
    }
    public void loadShip(Port port) {
        if ((MAXCONTAINER - container) <= port.getCountContainer()){
            port.setCountContainer(port.getCountContainer()-(MAXCONTAINER - container));
        container = MAXCONTAINER;
            System.out.println("Port" +port.getCountContainer() +" countainer");
            System.out.println("Корабль "+ currentThread().getName()+" загрузился");
        }else{
            System.out.println("Port" +port.getCountContainer() +" countainer");
            System.out.println("Корабль "+ currentThread().getName()+" не загрузился");
        }
    }
    public void unloadShip(Port port){
        if((MAXCONTAINER-container)<=(port.getMAXCONTAINER()-port.getCountContainer())) {
            port.setCountContainer(port.getCountContainer()+(MAXCONTAINER - container));
            container = 0;
            System.out.println("Port" +port.getCountContainer() +" countainer");
            System.out.println("Корабль "+ currentThread().getName()+" выгрузился");
        }else{
            System.out.println("Port" +port.getCountContainer() +" countainer");
            System.out.println("Корабль "+ currentThread().getName()+" не выгрузился");
        }
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();
            System.out.println("Корабль "+currentThread().getName()+" на загрузке");
            this.loadShip(port);
            this.unloadShip(port);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}

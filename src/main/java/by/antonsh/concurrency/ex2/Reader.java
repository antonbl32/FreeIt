package by.antonsh.concurrency.ex2;

import lombok.Data;
@Data
public class Reader implements Runnable{
    private Library library;
    public Reader(Library library) {
        this.library=library;
    }

    @Override
    public void run() {
        try {
            if(library.getBookInHands()&& library.getBookInLibrary()){
                System.out.println("2 книги получил "+Thread.currentThread().getName());
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

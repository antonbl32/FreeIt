package by.antonsh.concurrency.ex2;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/*
Маленькая библиотека. Доступны для чтения несколько книг. Одинаковых
книг в библиотеке нет. Некоторые выдаются на руки, некоторые только
в читальный зал. Читатель может брать на руки и в читальный зал несколько книг.
 */
@Data
public class Library {
    private Random random = new Random();
    private int numberBook = 0;
    private CopyOnWriteArrayList<Book> allBooks = new CopyOnWriteArrayList<>();

    public boolean getBookInHands() {
        for (int i = 0; i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            if (!book.isBusy() && book.isOnHands()) {
                book.setBusy(true);
                System.out.println(Thread.currentThread().getName() + " взял книгу: " + book.getBookName() + " на руки");
                return true;
            }
        }
        System.out.println("Осталось свободных книг для выдачи на руки: "+
                allBooks.stream().filter(r->!r.isBusy()&&r.isOnHands()).count());
        return false;
    }

    public boolean getBookInLibrary() {
        for (int i = 0; i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            if (!book.isBusy() && book.isJustInLibrary()) {
                book.setBusy(true);
                System.out.println(Thread.currentThread().getName() + " взял книгу в читальный зал: " + book.getBookName() + " на руки");
               return true;
            }
        }
        System.out.println("Осталось свободных книг для чтения в библиотеке: "+
                allBooks.stream().filter(r->!r.isBusy()&&r.isOnHands()).count());
        return false;
    }

    public Library() {
        addBooks();
    }

    public void addBooks() {
        for (int i = 0; i < 50; i++) {
            allBooks.add(new Book("Book " + numberBook++, random.nextBoolean(), random.nextBoolean(), false));
        }
    }
}

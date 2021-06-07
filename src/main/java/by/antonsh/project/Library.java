package by.antonsh.project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Library {

    private static final String fileName = "d:/mylibrary.xml";

    public static void main(String[] args) {
        Library lib = new Library();
        Books books;
        books = lib.getMyLibrary();
        System.out.println(books.getAllBooks());
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                books.add(new Book("Some any know", 1985, new Author("Denisov", "Vladislav"), Genre.AUTOBIOGRAPHY));
                lib.saveMyLibrary(books);
                break;
            case 2:
                System.out.println(books.sortByYear());
        }
    }


    public void saveMyLibrary(Books library) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class, Book.class, Genre.class, Author.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(library, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Books getMyLibrary() {
        Books library = new Books();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class, Book.class, Genre.class, Author.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            library = (Books) jaxbUnmarshaller.unmarshal(new FileInputStream(fileName));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return library;
    }

    public static void createBook(Books books) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("enter name of book:");
            String name = sc.next();
            System.out.println("enter year of book:");
            String year = "1111";
            Pattern pattern = Pattern.compile("\\w{4}");
            Matcher matcher = pattern.matcher(year);
            do {
                while (!sc.hasNextInt()) {
                    System.out.println("enter a year");
                    sc.next();
                }
                year=String.valueOf(sc.nextInt());
            } while (!matcher.find());
            int yearInInt=Integer.parseInt(year);
            Book book = new Book("Три танкиста и собака"
                    , 1991, new Author("Котеригин", "Василий"), Genre.ACTION);
            books.add(book);
        }
    }
}

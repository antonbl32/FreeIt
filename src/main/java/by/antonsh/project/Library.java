package by.antonsh.project;

import javax.xml.bind.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Library {

    private static final String fileName="d:/mylibrary.xml";

    public static void main(String[] args) {
        Books books=new Books();
        createBook((ArrayList<Book>) books.getBooks());
        saveMyLibrary(books);
        System.out.println(books.getBooks());
        books.getBooks().clear();
        getMyLibrary(books);
        System.out.println(books.getBooks());


    }
    public List<Book> sortByName(Books library){
        List<Book> sorted=new ArrayList<>(library.getBooks());
        sorted.sort(Comparator.comparing(Book::getNameOfBook));
        return sorted;
    }
    public List<Book> sortByYear(Books library){
        List<Book> sorted=new ArrayList<>(library.getBooks());
        sorted.sort(Comparator.comparing(Book::getDateOfBook));
        return sorted;
    }
    public static void saveMyLibrary(Books library){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Books.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Marshaller jaxbMarshaller = null;
        try {
            jaxbMarshaller = jaxbContext.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e) {
            e.printStackTrace();
        }

        try {
            jaxbMarshaller.marshal(library.getBooks(), new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    public  static void getMyLibrary(Books library){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Book.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            library.setBooks((List<Book>) jaxbUnmarshaller.unmarshal( new File(fileName) ));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
    public static void createBook(ArrayList<Book> books){
        Book book=new Book("Три танкиста и собака",1991,new Author("Котеригин","Василий"),Genre.ACTION);
        books.add(book);
    }
}

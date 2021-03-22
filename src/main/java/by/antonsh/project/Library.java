package by.antonsh.project;

import javax.xml.bind.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Library {
    private static List<Book> myLibrary;
    private static final String fileName="d:/mylibrary.xml";

    public static void main(String[] args) {
        createBook();
        saveMyLibrary();
        System.out.println(myLibrary);
        myLibrary.clear();
        getMyLibrary();
        System.out.println(myLibrary);


    }
    public List<Book> sortByName(){
        List<Book> sorted=new ArrayList<>(myLibrary);
        sorted.sort(Comparator.comparing(Book::getNameOfBook));
        return sorted;
    }
    public List<Book> sortByYear(){
        List<Book> sorted=new ArrayList<>(myLibrary);
        sorted.sort(Comparator.comparing(Book::getDateOfBook));
        return sorted;
    }
    public static void saveMyLibrary(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Book.class);
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
            jaxbMarshaller.marshal(myLibrary, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    public  static void getMyLibrary(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Book.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            myLibrary= (List<Book>) jaxbUnmarshaller.unmarshal( new File(fileName) );
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
    public static void createBook(){
        Book book=new Book("Три танкиста и собака",1991,new Author("Котеригин","Василий"),Genre.ACTION);
        myLibrary.add(book);
    }
}

package by.antonsh.project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private static List<Book> myLibrary;

    public static void main(String[] args) {

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



}

package by.antonsh.project;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@XmlRootElement(name = "allbooks")
@XmlAccessorType(XmlAccessType.PROPERTY)
class Books{

    private List<Book> allBooks;

    public List<Book> getAllBooks() {
        return allBooks;
    }

    @XmlElement(name = "listofbooks")
    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public void AddAllBooks(List<Book> mybooks) {
        this.allBooks.addAll(mybooks);
    }
    public void add(Book book){
        if(this.allBooks ==null){
            allBooks =new ArrayList<>();
        }
        this.allBooks.add(book);
    }

    public Books(List<Book> mybooks) {
        this.allBooks = mybooks;
    }

    public Books() {
    }
    public List<Book> sortByName() {
        List<Book> sorted = new ArrayList<>(this.getAllBooks());
        sorted.sort(Comparator.comparing(Book::getNameOfBook));
        return sorted;
    }

    public List<Book> sortByYear() {
        List<Book> sorted = new ArrayList<>(this.getAllBooks());
        sorted.sort(Comparator.comparing(Book::getDateOfBook));
        return sorted;
    }
}

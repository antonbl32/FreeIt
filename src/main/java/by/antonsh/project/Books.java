package by.antonsh.project;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "listbooks")
@XmlSeeAlso({Book.class})
public class Books implements Serializable {

    private List<Book> books=new ArrayList<>();

    @XmlElementWrapper(name="books")
    @XmlElementRef()
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

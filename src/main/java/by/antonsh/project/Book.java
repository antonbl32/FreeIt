package by.antonsh.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Book {
    public Book() {
    }

    private String nameOfBook;
    private int dateOfBook;
    private Author author;
    private Genre genre;

    public Book(String nameOfBook, int dateOfBook, Author author, Genre genre) {
        this.nameOfBook = nameOfBook;
        this.dateOfBook = dateOfBook;
        this.author = author;
        this.genre = genre;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    @XmlElement(name = "nameOfBook")
    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public int getDateOfBook() {
        return dateOfBook;
    }

    @XmlElement(name = "dateOfBook")
    public void setDateOfBook(int dateOfBook) throws ParseException {
        this.dateOfBook = dateOfBook;
    }

    public Author getAuthor() {
        return author;
    }

    @XmlElement(name = "author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    @XmlElement(name = "genre")
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(nameOfBook, book.nameOfBook) &&
                Objects.equals(dateOfBook, book.dateOfBook) &&
                Objects.equals(author, book.author) &&
                genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfBook, dateOfBook, author, genre);
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "nameOfBook='" + nameOfBook + '\'' +
                ", dateOfBook=" + dateOfBook +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }


}

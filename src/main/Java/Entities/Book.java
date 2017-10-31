package Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "searchBook", query = "select  b from  Book b where b.book_number=:booknum"),
        @NamedQuery(name = "viewAllBooks", query = "select  b from  Book b"),
        @NamedQuery(name = "deleteBook", query = "delete  from Book b where b.book_number=:booknum"),
        @NamedQuery( name = "viewBooksAvailable", query = "select  b from  Book  b where  b.status=:status1")

})


public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  long id;
    private  String name;
    private  String author;
    @Column(unique = true)
    private  String book_number;
    private Date yearofPublications;
    private String bookCategory;
    private  String bookLocation;
    private  String status;
    private  String isbNo;

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_number() {
        return book_number;
    }

    public void setBook_number(String book_number) {
        this.book_number = book_number;
    }

    public Date getYearofPublications() {
        return yearofPublications;
    }

    public void setYearofPublications(Date yearofPublications) {
        this.yearofPublications = yearofPublications;
    }



    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsbNo() {
        return isbNo;
    }

    public void setIsbNo(String isbNo) {
        this.isbNo = isbNo;
    }
}

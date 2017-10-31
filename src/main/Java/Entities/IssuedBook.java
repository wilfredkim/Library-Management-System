package Entities;

import javax.persistence.*;
import java.sql.Date;
@Entity
@NamedQueries({
        /*@NamedQuery(name = "returnBook",query = "delete from IssuedBook i where i.book=:book "),*/

        @NamedQuery(name = "viewIssuedBooks", query = "select  i from IssuedBook  i where i.returnStatus=:status"),
        @NamedQuery(name = "searchIssuedbooks",query = "select  i from  IssuedBook  i where  i.book.book_number=:bookid and i.student.regNo=:studid"),
})

public class IssuedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @ManyToOne
    Student student;
    @ManyToOne
    Book book;
    private Date dateofIssue;
    private  Date datetoreturn;
    private  String returnStatus;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateofIssue() {
        return dateofIssue;
    }

    public void setDateofIssue(Date dateofIssue) {
        this.dateofIssue = dateofIssue;
    }

    public Date getDatetoreturn() {
        return datetoreturn;
    }

    public void setDatetoreturn(Date datetoreturn) {
        this.datetoreturn = datetoreturn;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
}

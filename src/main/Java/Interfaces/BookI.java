package Interfaces;

import Entities.Book;
import Entities.IssuedBook;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface BookI {
    boolean addBook(Book book);

    boolean deleteBook(Book book);

    boolean updateBook(Book book);

    ArrayList<Book> viewAllbooks();
    ArrayList<IssuedBook> viewIssuedbooks(IssuedBook issuedBook);
    ArrayList<Book> viewAvailablebooks(Book book);

    Book searchBook(Book book);

    boolean issueBook(Book book, IssuedBook issuedBook);

    boolean returnBook(Book book,IssuedBook issuedBook);
    IssuedBook searchIssuedBook(String booknum, String studentid);

}

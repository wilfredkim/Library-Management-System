package Beans;

import DAOs.BookDAO;
import Entities.Book;
import Entities.IssuedBook;
import Interfaces.BookI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
@Stateless
@Local
public class BookBean implements BookI {
    @PersistenceContext
    EntityManager entityManager;

    public boolean addBook(Book book) {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.addBook(book);
    }

    public boolean deleteBook(Book book) {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.deleteBook(book);

    }

    public boolean updateBook(Book book) {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.updateBook(book);
    }

    public ArrayList<Book> viewAllbooks() {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.viewAllbooks();
    }

    public ArrayList<IssuedBook> viewIssuedbooks(IssuedBook issuedBook) {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.viewIssuedbooks(issuedBook);
    }
    public Book searchBook(Book book) {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.searchBook(book);
    }
    public boolean issueBook(Book book, IssuedBook issuedBook) {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.issueBook(book, issuedBook);
    }
    public boolean returnBook(Book book,IssuedBook issuedBook) {

        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.returnBook( book,issuedBook);
    }

    public IssuedBook searchIssuedBook(String booknum, String studentid) {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.searchIssuedBook(booknum,studentid);
    }

    public ArrayList<Book> viewAvailablebooks(Book book) {
        BookDAO bookDAO = new BookDAO(entityManager);
        return  bookDAO.viewAvailablebooks(book);
    }

}

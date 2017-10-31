package DAOs;

import Entities.Book;
import Entities.IssuedBook;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO  extends CustomDAO<Book>{


    public BookDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean addBook(Book book) {
       return  this.addCustom(book);
    }

    public boolean deleteBook(Book book) {
        try {
            int delete = entityManager.createNamedQuery("deleteBook").setParameter("booknum", book.getBook_number()).executeUpdate();
            if (delete > 0) {
                return true;
            }else {
                return  false;
            }
        }catch (PersistenceException px) {
            px.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(Book book) {
       try{
           entityManager.merge(book);
           return  true;
       }catch (PersistenceException px){
           px.printStackTrace();
           return  false;
       }
    }
@SuppressWarnings("unchecked")
    public ArrayList<Book> viewAllbooks() {
        try{
            return (ArrayList<Book>) entityManager.createNamedQuery("viewAllBooks").getResultList();
        } catch (PersistenceException px) {
            px.printStackTrace();
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    public ArrayList<IssuedBook> viewIssuedbooks(IssuedBook issuedBook) {
        try{
            return (ArrayList<IssuedBook>) entityManager.createNamedQuery("viewIssuedBooks").setParameter("status",issuedBook.getReturnStatus()).getResultList();
        } catch (PersistenceException px) {
            px.printStackTrace();
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    public ArrayList<Book> viewAvailablebooks(Book  book) {
        try{
            return (ArrayList<Book>) entityManager.createNamedQuery("viewBooksAvailable").setParameter("status1",book.getStatus()).getResultList();
        }catch (PersistenceException px) {
            px.printStackTrace();
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    public Book searchBook(Book book) {
        try {
            List<Book> bookList =  entityManager.createNamedQuery("searchBook").setParameter("booknum", book.getBook_number()).getResultList();
            return  bookList.size()>0? bookList.get(0):null;
        } catch (PersistenceException px) {
            px.printStackTrace();
            return null;
        }
    }
    public boolean issueBook(Book book, IssuedBook issuedBook) {
        //if(searchBook(book)!=null) {
            try {
                entityManager.merge(book);
                entityManager.persist(issuedBook);
                return true;
            } catch (PersistenceException px) {
                px.printStackTrace();
                return false;
            }

    }
    public boolean returnBook(Book book,IssuedBook issuedBook) {

        try{
            entityManager.merge(book);
            entityManager.merge(issuedBook);
            return true;
        }catch (PersistenceException px){
            px.printStackTrace();
            return  false;
        }
    }
    @SuppressWarnings("unchecked")
    public IssuedBook searchIssuedBook(String booknum, String studentid) {
        try{
            List<IssuedBook> issuedBooks= entityManager.createNamedQuery("searchIssuedbooks").setParameter("bookid",booknum).setParameter("studid",studentid).getResultList();
            return  issuedBooks.size()>0? issuedBooks.get(0):null;
        } catch (PersistenceException px) {
            px.printStackTrace();
            return null;
        }
    }
}

package Interfaces;

import Entities.Librarian;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface LibrarianI {


  boolean addLibrarian(Librarian librarian);
  ArrayList<Librarian> viewLibrarian();
  boolean deleteLibrarian(Librarian librarian);

}

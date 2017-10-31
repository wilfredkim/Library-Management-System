package Interfaces;

import Entities.Student;

import javax.ejb.Local;

@Local
public interface StudentI {
    boolean register(Student student);

    Student searchStudent(Student student);


}

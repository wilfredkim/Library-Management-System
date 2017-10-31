package Beans;

import DAOs.StudentDAO;
import Entities.AuditTrail;
import Entities.Student;
import Events.AuditTrailEvent;
import Interfaces.StudentI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
@Local
public class StudentBean implements StudentI {
    @PersistenceContext
    EntityManager entityManager;


    public boolean register(Student student) {
        StudentDAO studentDAO = new StudentDAO(entityManager);
        return  studentDAO.register(student);
    }





    public Student searchStudent(Student student) {
        StudentDAO studentDAO  = new StudentDAO(entityManager);
        return  studentDAO.searchStudent(student);
    }


}

package DAOs;

import Entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class StudentLoginDAO {
    EntityManager entityManager;

    public StudentLoginDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @SuppressWarnings("unchecked")
    public boolean login(Student student) {
        try {
            List<Student> studentList = entityManager.createNamedQuery("authenticate").setParameter("mail",student.getEmail()).setParameter("pass",student.getPassword()).getResultList();
            return  studentList.size()>0;
        }catch (PersistenceException px) {
            px.printStackTrace();
            return false;
        }
    }
}

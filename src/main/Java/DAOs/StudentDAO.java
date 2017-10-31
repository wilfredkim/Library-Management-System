package DAOs;

import Entities.Book;
import Entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class StudentDAO  extends CustomDAO<Student>{


    public StudentDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean register(Student student) {
        return  this.addCustom(student);
    }

    @SuppressWarnings("unchecked")
    public Student searchStudent(Student student) {
        try {
            List<Student> studentList =  entityManager.createNamedQuery("searchStudent").setParameter("regNo", student.getRegNo()).getResultList();
            return  studentList.size()>0? studentList.get(0):null;
        } catch (PersistenceException px) {
            px.printStackTrace();
            return null;
        }
    }




}

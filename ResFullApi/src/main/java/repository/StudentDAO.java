package repository;

import dto.StudentDTO;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

public class StudentDAO {
    public List<StudentDTO> getAllStudent() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {

            return session.createQuery("from STUDENTS ").list();
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public boolean addStudent(Student student) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
//          for (Student student : students
//                  ) {
            session.save(student);
//          }
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
    public boolean updateStudent(Student studentDTO){
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {

            session.beginTransaction();
            session.update(studentDTO);
            session.getTransaction().commit();
            return true;


        }catch (HibernateException e){
            System.out.println(e);

        }finally {
            session.close();
        }
        return  false;
    }
    public boolean deleteStudent(int id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            StudentDTO studentDTO = session.load(StudentDTO.class, id);
            session.delete(studentDTO);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}

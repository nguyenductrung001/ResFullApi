package repository;

import dto.StudentDTO;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.time.LocalDate;
import java.util.List;

public class StudentDAO {
    private String FullName;

    public List<Student> getAllStudent() {
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
            Student student= session.load(Student.class, id);
            session.delete(student);
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
    public void searchStudent(){
//       Session session  = HibernateUtils.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            List list = session
//                    .createQuery("from STUDENTS WHERE  FULLNAME like: name")
//                    .setParameter("name","%" + FullName+"%" ).list();
//            for (Object student:list
//                 ) {
//                System.out.println(student);
//            }
//        }catch (RuntimeException e){
//            session.getTransaction().rollback();
//            e.printStackTrace();
//        }finally {
//            session.flush();
//            session.close();
//        }
    }
    public List<Student> cmSinhNhat(){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            LocalDate today = LocalDate.now();
            int month = today.getMonthValue();
            int day = today.getDayOfMonth();
            Query<Student> query = session.createQuery("from STUDENTS where to_number(to_char(birthDay, 'MM')) = :p_month and to_number(to_char(birthDay, 'dd')) = :p_day");
            query.setParameter("p_month", month);
            query.setParameter("p_day", day);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public  List<Student> searchFullName(String name){
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from STUDENTS where lower(fullName)like lower(to_char(concat(concat('%',:p_student_name),'%' ))) ");
            query.setParameter("p_student_name",name );
            List<Student> students= query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }
    public  List<Student> searchMajor(String major){
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from STUDENTS where lower(maJor)like lower(to_char(concat(concat('%',:p_student_major),'%' ))) ");
            query.setParameter("p_student_major",major );
            List<Student> students= query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }
    public  List<Student> searchGender(String gender){
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from STUDENTS where lower(gender)like lower(to_char(concat(concat('%',:p_student_gender),'%' ))) ");
            query.setParameter("p_student_gender",gender );
            List<Student> students= query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public  List<Student> searchHometown(String hometown){
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from STUDENTS where lower(homeTown)like lower(to_char(concat(concat('%',:p_student_hometown),'%' ))) ");
            query.setParameter("p_student_hometown",hometown );
            List<Student> students= query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }
    public  List<Student> searchClassName(String className){
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from STUDENTS where lower(className)like lower(to_char(concat(concat('%',:p_student_className),'%' ))) ");
            query.setParameter("p_student_className",className );
            List<Student> students= query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }
    public List<Student> getStudentByAverage(double min, double max){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from STUDENTS where averageMark between :p_student_markMin and :p_student_markMax");
            query.setParameter("p_student_markMin", min);
            query.setParameter("p_student_markMax", max);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

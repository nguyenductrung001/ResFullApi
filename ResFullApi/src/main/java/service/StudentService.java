package service;

import dto.StudentDTO;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.StudentDAO;
import utils.HibernateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class StudentService {
    StudentDAO studentDAO  = new StudentDAO();





    public List<StudentDTO> getListStudent(){
        return studentDAO.getAllStudent();
    }

    public boolean insert(StudentDTO studentDTO){
        Student student = new Student();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        student.setAverageMark(studentDTO.getAverageMark());
        try {
            student.setBirthDay(sdf.parse(studentDTO.getBirthDay()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setGender(studentDTO.getGender());
        student.setClassName(studentDTO.getClassName());
        student.setHomeTown(studentDTO.getHomeTown());
        student.setMaJor(studentDTO.getMaJor());
        student.setFullName(studentDTO.getFullName());
        if (student.getFullName() == null) {

            return false;
        }else if (student.getFullName().length()>50){
            System.out.println("FullName khong duoc vượt quá 50 kí tự");
            return false;
        }

        if (student.getBirthDay() == null) {
            System.out.println("Ban pahi nhap ngay sinh!");
            return false;
        }
        if (student.getClassName() == null) {
            System.out.println("Ban phai nhap ngay lop hoc!");
            return false;
        }
        if (student.getMaJor() == null) {
            System.out.println("Ban pahi nhap khoa!");
            return false;
        }
        if (student.getHomeTown() == null) {
            System.out.println("Ban pahi nhap dia chi!");
            return false;
        }
        if (student.getGender() == null) {
            System.out.println("Ban pahi nhap gioi tinh!");
            return false;
        }
        if (student.getAverageMark() == null) {
            System.out.println("Ban pahi nhap diem trung binh!");
            return false;
        }
//        student.setId();

       return studentDAO.addStudent(student);
    }
    public boolean update(StudentDTO studentDTO){
         Student student = new Student();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        student.setAverageMark(studentDTO.getAverageMark());
//        student.setAverageMark(studentDTO.getAverageMark());
        try {
            student.setBirthDay(sdf.parse(studentDTO.getBirthDay()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setId(studentDTO.getId());
        student.setGender(studentDTO.getGender());
        student.setClassName(studentDTO.getClassName());
        student.setHomeTown(studentDTO.getHomeTown());
        student.setMaJor(studentDTO.getMaJor());
        student.setFullName(studentDTO.getFullName());
        if(student.getId() <= 0){
            return false;
        }
        if (student.getFullName() == null) {
            return false;
        }
        if (student.getBirthDay() == null){
            return false;
        }
        if (student.getClassName() == null){
            return false;
        }
        if (student.getMaJor() == null){
            return false;
        }
        if (student.getHomeTown() == null){
            return false;
        }
        if (student.getGender() == null){
            return false;
        }
        if (student.getAverageMark() == null){
            return false;
        }
        return studentDAO.updateStudent(student);

    }
public boolean delete(int id){
return studentDAO.deleteStudent(id);
}
}

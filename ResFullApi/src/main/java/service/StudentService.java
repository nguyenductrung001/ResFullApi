package service;

import dto.StudentDTO;
import entity.Student;
import repository.StudentDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class StudentService {
    StudentDAO studentDAO  = new StudentDAO();





    public List<Student> getListStudent(){
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
            System.out.println("Ban phai nhap  lop hoc!");
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
        }else if (student.getFullName().length()>50){
            System.out.println("FullName khong duoc vượt quá 50 kí tự");
            return false;
        }
        if (student.getBirthDay() == null){
            System.out.println("Ban pahi nhap ngay sinh!");
            return false;
        }
        if (student.getClassName() == null){
            System.out.println("Ban phai nhap ten lop hoc!");
            return false;
        }
        if (student.getMaJor() == null){
            System.out.println("Ban pahi nhap khoa!");
            return false;
        }
        if (student.getHomeTown() == null){
            System.out.println("Ban pahi nhap dia chi!");
            return false;
        }
        if (student.getGender() == null){
            System.out.println("Ban pahi nhap gioi tinh!");
            return false;
        }
        if (student.getAverageMark() == null){
            System.out.println("Ban pahi nhap diem trung binh!");
            return false;
        }
        return studentDAO.updateStudent(student);

    }
public boolean delete(int id){
return studentDAO.deleteStudent(id);
}
public List<Student> getListStudentBirthday(){
        return studentDAO.cmSinhNhat();
}
    public List<Student> getListStudentByName(String name){
        return studentDAO.searchFullName(name);
    }
    public List<Student> getListStudentByMajor(String major){
        return studentDAO.searchMajor(major);
    }
    public List<Student> getListStudentByGender(String gender){
        return studentDAO.searchGender(gender);
    }
    public List<Student> getListStudentByHometown(String hometown){
        return studentDAO.searchHometown(hometown);
    }
    public List<Student> getListStudentByClassName(String className){
        return studentDAO.searchClassName(className);
    }
    public List<Student> getListStudentAverageMark(double min , double max){
        return studentDAO.getStudentByAverage(min,max);
    }
}

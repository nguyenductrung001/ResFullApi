package controller;

import dto.StudentDTO;
import entity.Student;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/students")
public class StudentController {

    StudentService studentService = new StudentService();

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    @Path("/")
    public List<Student> getListStudent() {

        return studentService.getListStudent();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewStudent(StudentDTO studentDTO){
//        ObjectMapper mapper = new ObjectMapper();
//        Student student = mapper.convertValue(jsonNode, Student.class);
        return studentService.insert(studentDTO) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String UpdateStudent(StudentDTO studentDTO){
        return studentService.update(studentDTO) ? "update thanh cong" : "update that bai";
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String Delete(@PathParam("id") int id){
        return studentService.delete(id) ? "delete thanh cong" : "delete that bai";
    }
    @GET
    @Path("/birthday")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> Birthday(){
        return studentService.getListStudentBirthday();
    }
    @GET
    @Path("/search-name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> searchName(@PathParam("name") String name){
        return studentService.getListStudentByName(name);
    }
    @GET
    @Path("/search-major/{major}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> searchMajor(@PathParam("major") String major){
        return studentService.getListStudentByMajor(major);
    }
    @GET
    @Path("/search-gender/{gender}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> searchGender(@PathParam("gender") String gender){
        return studentService.getListStudentByGender(gender);
    }
    @GET
    @Path("/search-hometown/{hometown}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> searchHometown(@PathParam("hometown") String hometown){
        return studentService.getListStudentByHometown(hometown);
    }
    @GET
    @Path("/search-class-name/{classname}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> searchClassName(@PathParam("classname") String className){
        return studentService.getListStudentByClassName(className);
    }
    @GET
    @Path("/search-dtb/{min}/{max}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> searchDTB(@PathParam("min") double min, @PathParam("min") double max){
        return studentService.getListStudentAverageMark(min,max);
    }



}

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
    @GET
    public List<StudentDTO> getListStudent() {

        return studentService.getListStudent();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewTeacher(StudentDTO studentDTO){
//        ObjectMapper mapper = new ObjectMapper();
//        Student student = mapper.convertValue(jsonNode, Student.class);
        return studentService.insert(studentDTO) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String UpdateTeacher(StudentDTO studentDTO){
        return studentService.update(studentDTO) ? "update thanh cong" : "update that bai";
    }

}

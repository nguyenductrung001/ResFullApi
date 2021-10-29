package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@Entity(name = "STUDENTS")
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    /*

    Lỗi chỗ GeneratedValue
     */

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STU_SEQ")
    @SequenceGenerator(name = "STU_SEQ", sequenceName = "STUDENTS_SEQ", allocationSize = 1)

    @Column(name = "ID")
    Integer id;
    @Column(name = "FULLNAME")
    String fullName;
    @Column(name = "BIRTHDAY")
    Date birthDay;
    @Column(name = "CLASSNAME")
    String className;
    @Column(name = "MAJOR")
    String maJor;
    @Column(name = "HOMETOWN")
    String homeTown;
    @Column(name = "GENDER")
    String gender;
    @Column(name = "AVERAGEMARK")
    Double averageMark;


}

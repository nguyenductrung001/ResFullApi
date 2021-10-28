package dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {

    Integer Id;
    String fullName;
    String birthDay;
    String className;
    String maJor;
    String homeTown;
    String gender;
    Double averageMark;


}

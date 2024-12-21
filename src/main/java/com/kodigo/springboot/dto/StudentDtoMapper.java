package com.kodigo.springboot.dto;

import com.kodigo.springboot.entity.Student;
import java.util.Optional;

public class StudentDtoMapper {


  private StudentDtoMapper() {
    throw new UnsupportedOperationException("Esta clase no debe ser instanciada");
  }

  public static Optional<StudentDto> toDto(Student student) {

    if (student == null) {
      return Optional.empty();
    }

    StudentDto dto = new StudentDto();

    dto.setId(student.getId());
    dto.setFirstName(student.getFirstName());
    dto.setLastName(student.getLastName());
    dto.setEmail(student.getEmail());
    dto.setRegistrationDate(student.getRegistrationDate());


    return Optional.of(dto);


  }

public static Optional<Student> toEntity(StudentDto studentDto) {
  if (studentDto == null) {
    return Optional.empty();
  }

  Student student = new Student();
  student.setId(studentDto.getId());
  student.setFirstName(studentDto.getFirstName());
  student.setLastName(studentDto.getLastName());
  student.setEmail(studentDto.getEmail());
  student.setRegistrationDate(studentDto.getRegistrationDate());


  return Optional.of(student);
}

}

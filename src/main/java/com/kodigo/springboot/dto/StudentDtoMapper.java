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
    dto.setName(student.getName());
    dto.setEmail(student.getEmail());
    dto.setRegistrationDate(student.getRegistrationDate());

    return Optional.of(dto);


  }

}

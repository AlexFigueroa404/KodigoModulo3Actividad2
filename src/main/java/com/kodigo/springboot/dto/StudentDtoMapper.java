package com.kodigo.springboot.dto;

import com.kodigo.springboot.entity.Student;

public class StudentDtoMapper {


  private StudentDtoMapper() {
   throw new UnsupportedOperationException("Esta clase no debe ser instanciada");
  }

  public static StudentDto toDto(Student student) {

    if (student == null) {
      return null;
    }

    StudentDto dto = new StudentDto();

    dto.setId(student.getId());
    dto.setName(student.getName());
    dto.setEmail(student.getEmail());
    dto.setRegistrationDate(student.getRegistrationDate());

    return dto;


  }

}

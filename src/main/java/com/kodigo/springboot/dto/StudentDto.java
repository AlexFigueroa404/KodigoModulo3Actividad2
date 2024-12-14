package com.kodigo.springboot.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDto {

  private Integer id;
  private String name;
  private String lastName;
  private String email;
  private LocalDate registrationDate;


}

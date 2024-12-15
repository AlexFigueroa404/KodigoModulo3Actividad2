package com.kodigo.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDto {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("nombre")
  private String name;

  @JsonProperty("apellido")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("fechaRegistro")
  private LocalDate registrationDate;


}

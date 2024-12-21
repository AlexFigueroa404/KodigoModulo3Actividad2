package com.kodigo.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDto {

@JsonProperty("id")
private Integer id;

@JsonProperty("first_name")
private String firstName;


@JsonProperty("last_name")
private String lastName;

@JsonProperty("email")
private String email;

@JsonProperty("registration_date")
private LocalDate registrationDate;



}

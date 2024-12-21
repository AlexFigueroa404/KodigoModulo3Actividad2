package com.kodigo.springboot.controller;

import com.kodigo.springboot.dto.StudentDto;
import com.kodigo.springboot.service.IStudentService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

private final IStudentService studentService;


public StudentController(IStudentService studentService) {
  this.studentService = studentService;
}


}

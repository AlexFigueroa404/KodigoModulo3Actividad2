package com.kodigo.springboot.controller;

import com.kodigo.springboot.dto.StudentDto;
import com.kodigo.springboot.service.IStudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

private final IStudentService studentService;


public StudentController(IStudentService studentService) {
  this.studentService = studentService;
}

@GetMapping
public ResponseEntity<List<StudentDto>> getAllStudents() {
  List<StudentDto> students = studentService.findAll();
  return ResponseEntity.ok(students);
}

@GetMapping("/{id}")
public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) {
  Optional<StudentDto> student = studentService.findById(id);
  return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
  Optional<StudentDto> savedStudent = studentService.save(studentDto);
  return savedStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
}

@PutMapping("/{id}")
public ResponseEntity<StudentDto> updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
  Optional<StudentDto> updatedStudent = studentService.update(id, studentDto);
  return updatedStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
  studentService.deleteById(id);
  return ResponseEntity.noContent().build();
}
}

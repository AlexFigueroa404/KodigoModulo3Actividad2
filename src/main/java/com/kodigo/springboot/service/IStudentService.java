package com.kodigo.springboot.service;

import com.kodigo.springboot.dto.StudentDto;
import com.kodigo.springboot.entity.Student;
import java.util.List;
import java.util.Optional;

public interface IStudentService {

  List<StudentDto> findAllStudents();

  Optional<Student> findStudentById(Integer id);

  Student saveStudent(Student student);

  Student updateStudent(Student student);

  void deleteStudent(Integer id);
}

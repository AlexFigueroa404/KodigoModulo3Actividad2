package com.kodigo.springboot.service;

import com.kodigo.springboot.entity.Student;
import com.kodigo.springboot.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements IStudentService {


  private final StudentRepository studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<Student> findAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  public Optional<Student> findStudentById(Integer id) {
    return Optional.empty();
  }

  @Override
  public Student saveStudent(Student student) {
    return null;
  }

  @Override
  public Student updateStudent(Student student) {
    return null;
  }

  @Override
  public void deleteStudent(Integer id) {

  }
}

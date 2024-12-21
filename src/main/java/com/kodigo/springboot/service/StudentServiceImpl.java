package com.kodigo.springboot.service;

import com.kodigo.springboot.dto.StudentDto;
import com.kodigo.springboot.dto.StudentDtoMapper;
import com.kodigo.springboot.entity.Student;
import com.kodigo.springboot.repository.StudentRepository;
import java.util.ArrayList;
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
public List<StudentDto> findAll() {
  List<Student> students = studentRepository.findAll();
  List<StudentDto> studentDtos = new ArrayList<>();
  for (Student student : students) {
    StudentDtoMapper.toDto(student).ifPresent(studentDtos::add);
  }
  return studentDtos;
}

@Override
public Optional<StudentDto> findById(Integer id) {
  return studentRepository.findById(id).flatMap(StudentDtoMapper::toDto);
}

@Override
public Optional<StudentDto> save(StudentDto studentDto) {
  Student student = StudentDtoMapper.toEntity(studentDto).orElseThrow();
  Student savedStudent = studentRepository.save(student);
  return StudentDtoMapper.toDto(savedStudent);
}

@Override
public Optional<StudentDto> update(Integer id, StudentDto studentDto) {
  if (!studentRepository.existsById(id)) {
    return Optional.empty();
  }
  Student student = StudentDtoMapper.toEntity(studentDto).orElseThrow();
  student.setId(id);
  Student updatedStudent = studentRepository.save(student);
  return StudentDtoMapper.toDto(updatedStudent);
}

@Override
public void deleteById(Integer id) {
  studentRepository.deleteById(id);
}


}

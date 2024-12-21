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




}

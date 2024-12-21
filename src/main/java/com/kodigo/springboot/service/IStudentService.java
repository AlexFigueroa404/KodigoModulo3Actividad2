package com.kodigo.springboot.service;

import com.kodigo.springboot.dto.StudentDto;
import java.util.List;
import java.util.Optional;

public interface IStudentService {

List<StudentDto> findAll();

Optional<StudentDto> findById(Integer id);

Optional<StudentDto> save(StudentDto studentDto);

Optional<StudentDto> update(Integer id, StudentDto studentDto);

void deleteById(Integer id);
}

package com.kodigo.springboot.integration;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kodigo.springboot.dto.StudentDto;
import com.kodigo.springboot.entity.Student;
import com.kodigo.springboot.repository.StudentRepository;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import org.antlr.v4.runtime.misc.LogManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class StudentControllerIntegrationTest {

@LocalServerPort
private int port;

@Autowired
private TestRestTemplate restTemplate;

@Autowired
private StudentRepository studentRepository;

private Student student;

@BeforeEach
public void setUp() {
  studentRepository.deleteAll();

  student = new Student();
  student.setFirstName("John");
  student.setLastName("Doe");
  student.setEmail("john.doe@example.com");
  student.setRegistrationDate(LocalDate.now());
  studentRepository.save(student);
}

private String createURLWithPort(String uri) {
  return "http://localhost:" + port + uri;
}


}

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

private String baseUrl;

@BeforeEach
public void setUp() {
  baseUrl = "http://localhost:" + port + "/api/v1/students";
}

@Test
public void testCreateStudent() {
  StudentDto studentDto = new StudentDto();
  studentDto.setFirstName("John");
  studentDto.setLastName("Doe");
  studentDto.setEmail("john.doe@example.com");
  studentDto.setRegistrationDate(LocalDate.now());

  ResponseEntity<StudentDto> response = restTemplate.postForEntity(baseUrl, studentDto, StudentDto.class);

  assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
  StudentDto createdStudent = response.getBody();
  assertThat(createdStudent).isNotNull();
  assertThat(createdStudent.getId()).isNotNull();
  assertThat(createdStudent.getFirstName()).isEqualTo("John");
  assertThat(createdStudent.getLastName()).isEqualTo("Doe");
}
@Test
public void testGetStudentById() {

  StudentDto studentDto = new StudentDto();
  studentDto.setFirstName("Jane");
  studentDto.setLastName("Doe");
  studentDto.setEmail("jane.doe@example.com");
  studentDto.setRegistrationDate(LocalDate.now());

  ResponseEntity<StudentDto> createResponse = restTemplate.postForEntity(baseUrl, studentDto, StudentDto.class);
  StudentDto createdStudent = createResponse.getBody();

  ResponseEntity<StudentDto> getResponse = restTemplate.getForEntity(baseUrl + "/" + createdStudent.getId(), StudentDto.class);

  assertThat(getResponse.getStatusCode().is2xxSuccessful()).isTrue();
  StudentDto fetchedStudent = getResponse.getBody();
  assertThat(fetchedStudent).isNotNull();
  assertThat(fetchedStudent.getId()).isEqualTo(createdStudent.getId());
  assertThat(fetchedStudent.getFirstName()).isEqualTo("Jane");
  assertThat(fetchedStudent.getLastName()).isEqualTo("Doe");
}


@Test
public void testDeleteStudent() {
  StudentDto studentDto = new StudentDto();
  studentDto.setFirstName("Emily");
  studentDto.setLastName("Jones");
  studentDto.setEmail("emily.jones@example.com");
  studentDto.setRegistrationDate(LocalDate.now());

  ResponseEntity<StudentDto> createResponse = restTemplate.postForEntity(baseUrl, studentDto, StudentDto.class);
  StudentDto createdStudent = createResponse.getBody();

  restTemplate.delete(baseUrl + "/" + createdStudent.getId());

  ResponseEntity<StudentDto> getResponse = restTemplate.getForEntity(baseUrl + "/" + createdStudent.getId(), StudentDto.class);

  assertThat(getResponse.getStatusCode().is4xxClientError()).isTrue();
}

}

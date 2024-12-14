package com.kodigo.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Estudiante")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idEstudiante", nullable = false)
  private Integer id;

  @Column(name = "nombre", nullable = false, length = 100)
  private String name;

  @Column(name = "apellido", nullable = false, length = 100)
  private String lastName;

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @Column(name = "fechaRegistro")
  private LocalDate registrationDate;

  @OneToMany(mappedBy = "idStudent")
  private Set<Inscripcion> inscripcions = new LinkedHashSet<>();

  @OneToMany(mappedBy = "idStudent")
  private Set<Resultado> resultados = new LinkedHashSet<>();

}
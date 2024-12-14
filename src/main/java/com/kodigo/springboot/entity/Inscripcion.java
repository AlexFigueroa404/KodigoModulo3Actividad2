package com.kodigo.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Inscripcion", schema = "dbo")
public class Inscripcion {

  @Id
  @Column(name = "idInscripcion", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "idEstudiante", nullable = false)
  private Student idStudent;

  @Column(name = "fechaInscripcion", nullable = false)
  private LocalDate fechaInscripcion;

}
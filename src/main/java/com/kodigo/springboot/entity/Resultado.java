package com.kodigo.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Resultado", schema = "dbo")
public class Resultado {

  @Id
  @Column(name = "idResultado", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "idEstudiante", nullable = false)
  private Student idStudent;

  @Column(name = "puntajeObtenido", nullable = false, precision = 5, scale = 2)
  private BigDecimal puntajeObtenido;

}
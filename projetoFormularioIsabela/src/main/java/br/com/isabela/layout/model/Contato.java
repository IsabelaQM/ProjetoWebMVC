package br.com.isabela.layout.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Contato {

  public Contato(Long id, String name, Date date, String matricula) {
    this.id = id;
    this.name = name;
    this.date = date;
    this.matricula = matricula;
  }

  public Contato() {
  }

  private Long id;
  private String name;

  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date date;
  private String matricula;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

  public String getMatricula() {
      return matricula;
  }

  public void setMatricula(String matricula) {
      this.matricula = matricula;
  }

}

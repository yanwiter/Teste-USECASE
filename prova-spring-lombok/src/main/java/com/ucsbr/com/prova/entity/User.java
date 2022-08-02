package com.ucsbr.com.prova.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
@SuppressWarnings("serial")

@Entity(name="Usuario")
public class User implements Serializable {

@SuppressWarnings("unused")
private static final Long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="NOME_USER")
  private String nome;

  @Column(unique = true)
  private String login;

  @Column(nullable = false, name="EMAIL")
  private String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
  
  @Transient
  @Column(nullable = true, name="PERFIL_USUARIO")
  private Perfil perfil;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Perfil getPerfil() {
	return perfil;
}

public void setPerfil(Perfil perfil) {
	this.perfil = perfil;
}
  
}

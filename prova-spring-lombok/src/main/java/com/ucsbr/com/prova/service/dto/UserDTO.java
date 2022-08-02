package com.ucsbr.com.prova.service.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
@SuppressWarnings("serial")
public class UserDTO implements Serializable {


@SuppressWarnings("unused")
private static final Long serialVersionUID = 1L;

  @ApiModelProperty(value = "Código do usuário", example = "1")
  private Long id;

  @ApiModelProperty(value = "Nome do Usuário", example = "Jonas Doe", required = true)
  private String nome;

  @ApiModelProperty(value = "Nome do Login", example = "jonas", required = true)

  private String login;

  @ApiModelProperty(value = "E-mail", example = "jonas@net.com", required = true)

  private String email;

  @ApiModelProperty(value = "Password", example = "1234", required = true)
  private String password;

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
  
}

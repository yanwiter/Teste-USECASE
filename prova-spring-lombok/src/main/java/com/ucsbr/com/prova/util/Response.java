package com.ucsbr.com.prova.util;

import com.ucsbr.com.prova.entity.enumerator.ResponseStatus;

public class Response<T>{
private T data;
private ResponseStatus status;
private Integer errorCode;
private String errorMessage;
  
  
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
public ResponseStatus getStatus() {
	return status;
}
public void setStatus(ResponseStatus status) {
	this.status = status;
}
public Integer getErrorCode() {
	return errorCode;
}
public void setErrorCode(Integer errorCode) {
	this.errorCode = errorCode;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
  
  
}

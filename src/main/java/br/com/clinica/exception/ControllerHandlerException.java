package br.com.clinica.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerHandlerException {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> tratarErro404() {
		return ResponseEntity.notFound().build();
	}

}

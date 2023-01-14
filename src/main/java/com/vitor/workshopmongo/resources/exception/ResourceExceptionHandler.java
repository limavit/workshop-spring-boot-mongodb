package com.vitor.workshopmongo.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vitor.workshopmongo.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoung(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}

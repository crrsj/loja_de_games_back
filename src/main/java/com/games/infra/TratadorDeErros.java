package com.games.infra;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TratadorDeErros{

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErroTratado>idNaoEncontrado(){		
		var response = new ErroTratado(HttpStatus.NOT_FOUND,"ID não encontrado");
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
	
	

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	    }
	
}

package com.dawes.controlador;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

//@ControllerAdvice
@RequestMapping("/error")
public class ControladorErrores {

	@ExceptionHandler(AssertionError.class)
	public String errorinserccion (AssertionError exception, Model modelo) {
		modelo.addAttribute("error", exception.getMessage());
		return "error";
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public String errorViolacion(DataIntegrityViolationException exception, Model modelo) {
		modelo.addAttribute("error", exception.getMessage());
		return "error";
	}
	@ExceptionHandler(NoSuchElementException.class)
	public String erorr(NoSuchElementException exception, Model modelo) {
		modelo.addAttribute("error", exception.getMessage());
		return "error";
	}
}

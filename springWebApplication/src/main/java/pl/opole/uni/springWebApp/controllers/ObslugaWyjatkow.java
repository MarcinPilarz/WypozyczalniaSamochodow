package pl.opole.uni.springWebApp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pl.opole.uni.springWebApp.models.BladAtrybutu;
import pl.opole.uni.springWebApp.models.BladOdpowiedz;

@RestControllerAdvice
public class ObslugaWyjatkow {

	
	/**
     * Obsługuje wyjątek MethodArgumentNotValidException, który jest rzucony, gdy walidacja parametrów żądania nie powiedzie się.
     * 
     * @param ex wyjątek MethodArgumentNotValidException
     * @return obiekt ResponseEntity zawierający odpowiedź z błędami walidacji
     */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<BladOdpowiedz> handleValidationException(MethodArgumentNotValidException ex) {
		List<FieldError> bladAtrybutow = ex.getBindingResult().getFieldErrors();
		List<BladOdpowiedz> bladOdpowiedzi = new ArrayList<>();

		for (FieldError bladAtrybutu : bladAtrybutow) {
			BladOdpowiedz bladOdpowiedz = new BladOdpowiedz(bladAtrybutu.getField(), bladAtrybutu.getDefaultMessage());
			bladOdpowiedzi.add(bladOdpowiedz);
		}

		BladOdpowiedz bladOdpowiedz = new BladOdpowiedz("Błąd Walidacji");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bladOdpowiedz);
	}

	/**
     * Obsługuje wyjątek Exception, który jest rzucony, gdy wystąpi ogólny błąd.
     * 
     * @param ex wyjątek Exception
     * @return obiekt ResponseEntity zawierający odpowiedź z ogólnym błędem
     */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<BladOdpowiedz> handleGenericException(Exception ex) {
		BladOdpowiedz bladOdpowiedz = new BladOdpowiedz("Wystąpił bład");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bladOdpowiedz);
	}
}

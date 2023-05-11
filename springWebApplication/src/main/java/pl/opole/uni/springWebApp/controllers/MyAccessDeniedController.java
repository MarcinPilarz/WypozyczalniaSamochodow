package pl.opole.uni.springWebApp.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.access.AccessDeniedException;

@ControllerAdvice
public class MyAccessDeniedController {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException() {
        return "access-denied";
    }
}

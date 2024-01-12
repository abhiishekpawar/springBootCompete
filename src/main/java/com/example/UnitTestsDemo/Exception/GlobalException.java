package com.example.UnitTestsDemo.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleUserNotFoundException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>("user Not found", HttpStatus.NOT_FOUND);
    }
}

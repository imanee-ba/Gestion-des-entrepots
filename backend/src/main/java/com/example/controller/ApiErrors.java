package com.example.controller;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
@RestControllerAdvice public class ApiErrors {
 @ExceptionHandler(ResponseStatusException.class) public ResponseEntity<Map<String,Object>> http(ResponseStatusException ex){
  return ResponseEntity.status(ex.getStatusCode()).body(Map.of("message",Objects.toString(ex.getReason(),"Erreur")));
 }
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,Object>> invalid(MethodArgumentNotValidException ex){
  return ResponseEntity.badRequest().body(Map.of("message",ex.getBindingResult().getFieldErrors().stream().findFirst().map(e->e.getField()+": "+e.getDefaultMessage()).orElse("Saisie invalide")));
 }
 @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class) public ResponseEntity<Map<String,Object>> conflict(Exception ex){return ResponseEntity.status(409).body(Map.of("message","Doublon ou contrainte de base de données"));}
}

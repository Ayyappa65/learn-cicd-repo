package com.acadamate.faculty.controller;

import java.util.HashSet;
import java.util.Set; 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {

    private final Set<String> faculty = new HashSet<>();

    @GetMapping
    public ResponseEntity<Set<String>> getAllFaculty() {
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getFacultyByName(@PathVariable String name) {
        return faculty.stream()
                .filter(f -> f.equalsIgnoreCase(name))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    @GetMapping("/add/{name}")
    public ResponseEntity<String> addFaculty(@PathVariable String name) {
        faculty.add(name);
        return ResponseEntity.ok("Faculty member added: " + name);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteFaculty(@PathVariable String name) {
        if (faculty.remove(name)) {
            return ResponseEntity.ok("Faculty member deleted: " + name);
        } else {
            return ResponseEntity.notFound().build();       
        }
    }
}
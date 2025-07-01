package com.acadamate.faculty.controller;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {
   
    @GetMapping
    public ResponseEntity<String> getAllFaculty() {
        return ResponseEntity.ok("Get all faculty members");
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<String> getFacuEntityltyById(@PathVariable Long id) {
        return ResponseEntity.ok("Get faculty member with ID: " + id);
    }
 
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<String> getFacultyByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok("Get faculty members in department with ID: " + departmentId);
        // Implement logic to fetch faculty members by department
    }
 
}
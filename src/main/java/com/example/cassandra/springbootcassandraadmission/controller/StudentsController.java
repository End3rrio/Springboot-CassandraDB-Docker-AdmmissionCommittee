package com.example.cassandra.springbootcassandraadmission.controller;


import com.example.cassandra.springbootcassandraadmission.ResourceNotFoundException;
import com.example.cassandra.springbootcassandraadmission.model.Student;
import com.example.cassandra.springbootcassandraadmission.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class StudentsController {
    @Autowired
    StudentsRepository studentsRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
       return studentsRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id")Integer id){
        Student student = studentsRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Student not found for this id: " + id)
        );
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/students/{surname}")
    public ResponseEntity<Student> findBySurname(@PathVariable("surname")String surname){
        Student student = (Student) studentsRepository.findStudentBySurname(surname);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        studentsRepository.save(student);
        return student;
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
        Optional<Student> studentData = studentsRepository.findById(id);

        if (studentData.isPresent()){
            Student _student = studentData.get();
            _student.setName(student.getName());
            _student.setSurname(student.getSurname());
            _student.setBirthday(student.getBirthday());
            _student.setAddress(student.getAddress());
            _student.setPhoneNumber(student.getPhoneNumber());
            _student.setEmail(student.getEmail());
            _student.setPersonalInfo(student.getPersonalInfo());
            return new ResponseEntity<>(studentsRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/students")
    public ResponseEntity<HttpStatus> deleteAllStudents(){
        try {
            studentsRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id")Integer id){
        Student student = studentsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not found for this id: " + id)
        );
        studentsRepository.delete(student);
        return ResponseEntity.ok().build();
    }
}

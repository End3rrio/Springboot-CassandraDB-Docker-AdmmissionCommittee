package com.example.cassandra.springbootcassandraadmission.controller;


import com.example.cassandra.springbootcassandraadmission.ResourceNotFoundException;
import com.example.cassandra.springbootcassandraadmission.model.Applicant;
import com.example.cassandra.springbootcassandraadmission.repository.ApplicantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ApplicantsController {

    @Autowired
    ApplicantsRepository applicantsRepository;

    @GetMapping("/applicants")
    public List<Applicant> getAllApplicants(){
        return applicantsRepository.findAll();
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable("id") Integer id){
        Applicant applicant = applicantsRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Applicant not found for this id: " + id)
        );
        return ResponseEntity.ok().body(applicant);
    }

    @GetMapping("/applicants/{surname}")
    public ResponseEntity<Applicant> getApplicantBySurname(@PathVariable("surname") String surname){
        Applicant applicant = (Applicant) applicantsRepository.findApplicantBySurname(surname);
        return ResponseEntity.ok().body(applicant);
    }

    @PostMapping("/applicants")
    public Applicant createApplicant(@RequestBody Applicant applicant){
        applicantsRepository.save(applicant);
        return applicant;
    }

    @DeleteMapping("/applicants")
    public ResponseEntity<HttpStatus> deleteAllApplicants(){
        try{
            applicantsRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/applicants/{id}")
    public ResponseEntity<HttpStatus> deleteApplicant(@PathVariable("id") Integer id){
        Applicant applicant = applicantsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Applicant not found for this id: " + id)
        );
        applicantsRepository.delete(applicant);
        return ResponseEntity.ok().build();
    }
}

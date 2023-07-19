package com.example.cassandra.springbootcassandraadmission.controller;

import com.example.cassandra.springbootcassandraadmission.ResourceNotFoundException;
import com.example.cassandra.springbootcassandraadmission.model.AdmissionCommittee;
import com.example.cassandra.springbootcassandraadmission.repository.AdmissionCommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdmissionCommitteeController {

    @Autowired
     AdmissionCommitteeRepository admissionCommitteeRepository;

    @GetMapping("/members")
    public List<AdmissionCommittee> getMembers(){
        return admissionCommitteeRepository.findAll();
    }

    @GetMapping("/members/get_by_id/{id}")
    public ResponseEntity<AdmissionCommittee> getMemberById(@PathVariable("id") Integer id){
        AdmissionCommittee member = admissionCommitteeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member not found for this id: " + id)
        );
        return ResponseEntity.ok().body(member);
    }

    @GetMapping("/members/{surname}")
    public ResponseEntity<AdmissionCommittee> getMemberBySurname(@PathVariable("surname") String surname){
        AdmissionCommittee member = (AdmissionCommittee) admissionCommitteeRepository.findMemberBySurname(surname);
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/members")
    public AdmissionCommittee createMember(@RequestBody AdmissionCommittee member){
        admissionCommitteeRepository.save(member);
        return member;
    }

    @DeleteMapping("/members")
    public ResponseEntity<HttpStatus> deleteAllMembers(){
        try{
            admissionCommitteeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id")Integer id){
        AdmissionCommittee member = admissionCommitteeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member not found for this id: " + id)
        );
        admissionCommitteeRepository.delete(member);
        return ResponseEntity.ok().build();
    }
}

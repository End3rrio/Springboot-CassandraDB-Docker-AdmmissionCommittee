package com.example.cassandra.springbootcassandraadmission.controller;

import com.example.cassandra.springbootcassandraadmission.ResourceNotFoundException;
import com.example.cassandra.springbootcassandraadmission.model.Notes;
import com.example.cassandra.springbootcassandraadmission.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class NotesController {
    @Autowired
    NotesRepository notesRepository;

    @GetMapping("/notes")
    public List<Notes> getAllNotes(){
        return notesRepository.findAll();
    }

    @GetMapping("/notes/get_by_id/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable("id") Integer id){
        Notes notes = notesRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Notes not found for this id: " + id)
        );
        return ResponseEntity.ok().body(notes);
    }


    @PostMapping("/notes")
    public Notes createNote(@RequestBody Notes notes){
        notesRepository.save(notes);
        return notes;
    }

    @DeleteMapping("/notes")
    public ResponseEntity<HttpStatus> deleteAllNotes(){
        try{
            notesRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable("id") Integer id){
        Notes notes = notesRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Notes not found for this id: " + id)
        );
        notesRepository.delete(notes);
        return ResponseEntity.ok().build();
    }
}


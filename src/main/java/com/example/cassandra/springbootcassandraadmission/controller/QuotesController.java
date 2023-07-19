package com.example.cassandra.springbootcassandraadmission.controller;



import com.example.cassandra.springbootcassandraadmission.ResourceNotFoundException;
import com.example.cassandra.springbootcassandraadmission.model.Quote;
import com.example.cassandra.springbootcassandraadmission.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class QuotesController {
    @Autowired
    QuotesRepository quotesRepository;

    @GetMapping("/quotes")
    public List<Quote> getAllQuotes(){
        return quotesRepository.findAll();
    }

    @GetMapping("/quotes/{availableSlots}")
    public ResponseEntity<Quote> getQuotesByAvailableSlots(@PathVariable("availableSlots") int availableSlots){
        Quote quote = (Quote) quotesRepository.findQuoteByAvailableSlots(availableSlots);
        return ResponseEntity.ok().body(quote);
    }

    @PostMapping("/quotes")
    public Quote createQuote(@RequestBody Quote quote){
        quotesRepository.save(quote);
        return quote;
    }

    @DeleteMapping("/quotes")
    public ResponseEntity<HttpStatus> deleteAllQuotes(){
        try {
            quotesRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/quotes/{id}")
    public ResponseEntity<HttpStatus> deleteQuote(@PathVariable("id") Integer id){
        Quote quote = quotesRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Quote not found for this id: " + id)
        );
        quotesRepository.delete(quote);
        return ResponseEntity.ok().build();
    }
}

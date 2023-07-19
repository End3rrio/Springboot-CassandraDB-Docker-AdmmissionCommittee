package com.example.cassandra.springbootcassandraadmission.repository;

import com.example.cassandra.springbootcassandraadmission.model.Quote;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotesRepository extends CassandraRepository<Quote, Integer> {
    @AllowFiltering
    List<Quote> findQuoteByAvailableSlots(int availableSlots);
}

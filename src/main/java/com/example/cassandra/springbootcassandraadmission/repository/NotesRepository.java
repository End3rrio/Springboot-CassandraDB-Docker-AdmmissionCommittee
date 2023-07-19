package com.example.cassandra.springbootcassandraadmission.repository;

import com.example.cassandra.springbootcassandraadmission.model.Notes;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CassandraRepository<Notes, Integer> {

}

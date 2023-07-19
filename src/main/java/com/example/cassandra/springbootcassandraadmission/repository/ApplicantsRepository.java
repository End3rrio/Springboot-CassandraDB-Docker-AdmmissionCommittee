package com.example.cassandra.springbootcassandraadmission.repository;

import com.example.cassandra.springbootcassandraadmission.model.Applicant;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantsRepository extends CassandraRepository<Applicant, Integer> {
    @AllowFiltering
    List<Applicant> findApplicantBySurname(String surname);
}

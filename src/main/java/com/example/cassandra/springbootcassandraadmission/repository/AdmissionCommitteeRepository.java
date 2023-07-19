package com.example.cassandra.springbootcassandraadmission.repository;

import com.example.cassandra.springbootcassandraadmission.model.AdmissionCommittee;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionCommitteeRepository extends CassandraRepository<AdmissionCommittee, Integer> {
    @AllowFiltering
    List<AdmissionCommittee> findMemberBySurname(String surname);
}

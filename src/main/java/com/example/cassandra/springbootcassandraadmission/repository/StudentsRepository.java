package com.example.cassandra.springbootcassandraadmission.repository;

import com.example.cassandra.springbootcassandraadmission.model.Student;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends CassandraRepository<Student, Integer>{
    @AllowFiltering
    List<Student> findStudentBySurname(String surname);
}

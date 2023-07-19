package com.example.cassandra.springbootcassandraadmission.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class AdmissionCommittee {
    @PrimaryKeyColumn(name="id",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int id;
    @PrimaryKeyColumn(name="name", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String name;
    @PrimaryKeyColumn(name="surname", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String surname;
    @Column("position")
    private String position;
    @Column("jobofferdate")
    private String jobOfferDate;

    public AdmissionCommittee() {

    }

    public AdmissionCommittee(int id, String name, String surname, String position, String jobOfferDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.jobOfferDate = jobOfferDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobOfferDate() {
        return jobOfferDate;
    }

    public void setJobOfferDate(String jobOfferDate) {
        this.jobOfferDate = jobOfferDate;
    }

    @Override
    public String toString() {
        return "AdmissionCommittee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", jobOfferDate=" + jobOfferDate +
                '}';
    }
}

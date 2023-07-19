package com.example.cassandra.springbootcassandraadmission.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table
public class Applicant {
    @PrimaryKeyColumn(name="id",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int id;
    @PrimaryKeyColumn(name="first_name", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String name;
    @PrimaryKeyColumn(name="second_name", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String surname;
    @Column("birthday")
    private String birthday;
    @Column("address")
    private String address;
    @Column("phoneNumber")
    private String phoneNumber;
    @Column("email")
    private String email;
    @Column("educationInfo")
    private String educationInfo;
    @Column("trainingDirection")
    private String trainingDirection;
    @Column("entranceExamsResults")
    private int entranceExamsResults;
    @Column("applicationStatus")
    private String applicationStatus;

    public Applicant() {

    }

    public Applicant(int id, String name, String surname, String birthday, String address, String phoneNumber, String email, String educationInfo, String trainingDirection, int entranceExamsResults, String applicationStatus) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.educationInfo = educationInfo;
        this.trainingDirection = trainingDirection;
        this.entranceExamsResults = entranceExamsResults;
        this.applicationStatus = applicationStatus;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducationInfo() {
        return educationInfo;
    }

    public void setEducationInfo(String educationInfo) {
        this.educationInfo = educationInfo;
    }

    public String getTrainingDirection() {
        return trainingDirection;
    }

    public void setTrainingDirection(String trainingDirection) {
        this.trainingDirection = trainingDirection;
    }

    public int getEntranceExamsResults() {
        return entranceExamsResults;
    }

    public void setEntranceExamsResults(int entranceExamsResults) {
        this.entranceExamsResults = entranceExamsResults;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", educationInfo='" + educationInfo + '\'' +
                ", trainingDirection='" + trainingDirection + '\'' +
                ", entranceExamsResults=" + entranceExamsResults +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }
}

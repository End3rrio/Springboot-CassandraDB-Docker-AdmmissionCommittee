package com.example.cassandra.springbootcassandraadmission.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("students")
public class Student {
    @PrimaryKeyColumn(name="id",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int id;
    @PrimaryKeyColumn(name="name", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String name;
    @PrimaryKeyColumn(name="surname", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String surname;
    @Column("birthday")
    private String birthday;
    @Column("address")
    private String address;
    @Column("phonenumber")
    private String phoneNumber;
    @Column("email")
    private String email;
    @Column("personalinfo")
    private String personalInfo;

    public Student() {

    }

    public Student(int id, String name, String surname, String birthday, String address, String phoneNumber, String email, String educationInfo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.personalInfo = educationInfo;
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

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(String educationInfo) {
        this.personalInfo = educationInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", educationInfo='" + personalInfo + '\'' +
                '}';
    }
}

package com.example.cassandra.springbootcassandraadmission.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("note")
public class Notes {
    @PrimaryKeyColumn(name="id",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int id;

    @PrimaryKeyColumn(name="student_id", ordinal = 0,type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private int student_id;
    @Column("note")
    private String notes;
    @Column("passingDate")
    private String passingDate;

    public Notes() {

    }

    public Notes(int id, int student_id, String subject, String notes, String passingDate) {
        this.id = id;
        this.student_id = student_id;
        this.notes = notes;
        this.passingDate = passingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNote(String notes) {
        this.notes = notes;
    }

    public String getPassingDate() {
        return passingDate;
    }

    public void setPassingDate(String passingDate) {
        this.passingDate = passingDate;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", note=" + notes +
                ", passingDate=" + passingDate +
                '}';
    }
}

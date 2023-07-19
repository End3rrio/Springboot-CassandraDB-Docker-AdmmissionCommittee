package com.example.cassandra.springbootcassandraadmission.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("quote")
public class Quote {
    @PrimaryKeyColumn(name="id",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int id;

    @Column("trainingDirection")
    private String trainingDirection;
    @Column("availableSlots")
    private int availableSlots;

    public Quote() {

    }

    public Quote(int id, String trainingDirection, int availableSlots) {
        this.id = id;
        this.trainingDirection = trainingDirection;
        this.availableSlots = availableSlots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainingDirection() {
        return trainingDirection;
    }

    public void setTrainingDirection(String trainingDirection) {
        this.trainingDirection = trainingDirection;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "id=" + id +
                ", trainingDirection='" + trainingDirection + '\'' +
                ", availableSlots=" + availableSlots +
                '}';
    }
}

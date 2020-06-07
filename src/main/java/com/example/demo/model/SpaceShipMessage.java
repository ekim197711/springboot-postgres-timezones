package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SpaceShipMessage {
    @Id
    @GeneratedValue
    private Integer id;
    private String message;
    @Column(columnDefinition = "timestamptz")
    private ZonedDateTime dateTime;
}

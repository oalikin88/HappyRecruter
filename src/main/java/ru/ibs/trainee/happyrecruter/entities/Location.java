package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String locationName;
    private String locationAddress;
}

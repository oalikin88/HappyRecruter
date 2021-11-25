package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type4 {

    @Id
    @GeneratedValue
    private Long Id;

    private String type4Name;
}

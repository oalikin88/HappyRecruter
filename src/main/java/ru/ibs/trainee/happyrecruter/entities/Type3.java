package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type3 {

    @Id
    @GeneratedValue
    private Long id;

    private String type3Name;

}

package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProjectStatus {

    @Id
    @GeneratedValue
    private Long id;


}

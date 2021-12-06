package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class SubjectArea {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}

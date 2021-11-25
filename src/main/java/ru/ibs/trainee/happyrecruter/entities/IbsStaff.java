package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IbsStaff {

    @Id
    @GeneratedValue
    private Long id;

    private String fio;
    private String position;
    private String department;


    @OneToOne
    private Project project;
}

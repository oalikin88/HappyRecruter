package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffList {

    @Id
    @GeneratedValue
    private Long id;

    private String staffName;


}

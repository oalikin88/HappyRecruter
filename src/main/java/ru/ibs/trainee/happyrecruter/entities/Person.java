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
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String fio;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_role")
    private Role role;

}
package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ibs.trainee.happyrecruter.model.Role;
import ru.ibs.trainee.happyrecruter.model.Status;



@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
   
    


 
}
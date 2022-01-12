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
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
    
    
	public User(String firstName, String lastName, String email, String password, Role role, Status status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}
    
    
    
    

 
}
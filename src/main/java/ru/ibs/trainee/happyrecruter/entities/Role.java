package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ibs.trainee.happyrecruter.auth.ERole;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ERole name;

    
    
    public Role(ERole name) {
		this.name = name;
	}



	@ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
    

}
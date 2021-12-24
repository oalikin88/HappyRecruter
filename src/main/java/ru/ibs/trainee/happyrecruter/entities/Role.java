package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data

public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    

    public Role(String name, Set<User> users) {
		super();
		this.name = name;
		this.users = users;
	}


	@ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
    

}
package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor


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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}

	

}
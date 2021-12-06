package ru.ibs.trainee.happyrecruter.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String fio;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "persons_roles",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
        role.getPersons().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getPersons().remove(this);
    }

    // здесь ещё переопределяют методы equals и hashcode
}
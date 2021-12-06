package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByLogin(String login);
}

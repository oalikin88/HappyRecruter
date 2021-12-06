package ru.ibs.trainee.happyrecruter.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.trainee.happyrecruter.entities.Person;
import ru.ibs.trainee.happyrecruter.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;


    public Person getPerson(String login) {
        return personRepository.findByLogin(login);
    }
}

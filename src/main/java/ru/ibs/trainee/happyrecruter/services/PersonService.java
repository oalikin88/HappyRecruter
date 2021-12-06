package ru.ibs.trainee.happyrecruter.services;

import ru.ibs.trainee.happyrecruter.entities.Person;

public interface PersonService {
    Person getPerson(String login);
}


package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
}

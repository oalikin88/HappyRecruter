package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}

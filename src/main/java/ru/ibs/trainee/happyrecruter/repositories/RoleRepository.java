package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}

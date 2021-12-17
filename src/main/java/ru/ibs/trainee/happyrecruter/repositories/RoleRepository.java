package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.trainee.happyrecruter.auth.ERole;
import ru.ibs.trainee.happyrecruter.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);
	
	
}

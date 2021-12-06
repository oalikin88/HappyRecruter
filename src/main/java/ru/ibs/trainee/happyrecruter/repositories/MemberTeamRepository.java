package ru.ibs.trainee.happyrecruter.repositories;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.MemberTeam;

public interface MemberTeamRepository extends CrudRepository<MemberTeam, Long> {
	
	
}

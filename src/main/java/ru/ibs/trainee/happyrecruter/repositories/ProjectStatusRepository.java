package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.ProjectStatus;

public interface ProjectStatusRepository extends CrudRepository<ProjectStatus, Long> {
	ProjectStatus findByStatusValue(String statusValue);
	ProjectStatus findProjectStatusByStatusValue(String statusValue);
	Collection<ProjectStatus> findAll();
}

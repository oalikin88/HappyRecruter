package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.ibs.trainee.happyrecruter.entities.Project;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	List<Project> findAll();

	@Query(value = "Select * from project", nativeQuery = true)
	Collection<Project> findAllQuery();


}
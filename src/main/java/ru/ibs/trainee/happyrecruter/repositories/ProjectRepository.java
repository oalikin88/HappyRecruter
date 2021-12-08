package ru.ibs.trainee.happyrecruter.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	
	@Override
    public List<Project> findAll();
	
	@Query(value = "Select * from project",
			nativeQuery = true)
	public Collection<Project> findAllQuery();
	
}

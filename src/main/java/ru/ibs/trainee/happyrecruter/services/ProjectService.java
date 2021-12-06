package ru.ibs.trainee.happyrecruter.services;

import java.util.List;

import ru.ibs.trainee.happyrecruter.entities.Project;

public interface ProjectService {
	
	Project getProject(Long id);
	
	Object openProjects(Long id);
	
	Project createProject(Project Project);
	
	Project editProject(Project project);
		
	void deleteProject(Long id);

}

package ru.ibs.trainee.happyrecruter.services;

import java.util.Collection;
import java.util.List;

import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.Project;

public interface ProjectService {
	
	Project getProject(Long id);
	
	Project openProjects(Long id);
	
	Project createProject(Project Project);
	
	Project editProject(Project project);
		
	void deleteProject(Long id);
	
	List<ProjectDTOView> projectDTOViewSortByName();

	List<ProjectDTOView> showTest();
	

}

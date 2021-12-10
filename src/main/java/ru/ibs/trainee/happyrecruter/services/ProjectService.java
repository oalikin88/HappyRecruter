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
	List<ProjectDTOView> projectDTOViewSortByProjectName();
	List<ProjectDTOView> projectDTOViewsSortByStartDate();
	List<ProjectDTOView> showRegistryCards();
	List<ProjectDTOView> projectDTOViewsSortByStatus();
	List<ProjectDTOView> projectDTOViewSortByProjectNameReversed();
	List<ProjectDTOView> projectDTOViewsSortByStartDateReversed();
	List<ProjectDTOView> projectDTOViewsSortByStatusReversed();
	List<ProjectDTOView> projectDTOViewSortByDatePeopleStartWorking();
	List<ProjectDTOView> projectDTOViewSortByDatePeopleStartWorkingReversed();
	List<ProjectDTOView> projectDTOViewSortedByDelegate();
	List<ProjectDTOView> projectDTOViewSortedByDelegateReversed();
	List<ProjectDTOView> projectDTOViewSortByCompanyName();
	List<ProjectDTOView> projectDTOViewSortByCompanyNameReversed();

}

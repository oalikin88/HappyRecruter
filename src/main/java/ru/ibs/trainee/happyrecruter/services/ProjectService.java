package ru.ibs.trainee.happyrecruter.services;

import java.util.List;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.Project;

public interface ProjectService {
	
	Project getProject(Long id);
	Project openProjects(Long id);
	Project createProject(Project Project);
	Project editProject(Project project, Long id);	
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
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilter(String companyNameFilter, String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyName(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProject(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(String companyNameFilter,
			String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthor(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthor(String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthor(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCompanyName(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCompanyNameReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDelegateReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDelegate(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCreateDateReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCreateDate(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByStatusReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByStatus(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDateStartPeopleWorkReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDateStartPeopleWork(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByProjectNameReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByProjectName(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter);
	
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByProjectName(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByProjectNameReversed(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDatePeopleStartWork(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDatePeopleStartWorkReversed(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByStatusReversed(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByStatus(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDateCreate(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDateCreateReversed(String statusProjectFilter,
			String authorCardFilter);
	
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDelegate(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDelegateReversed(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByCompanyName(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByCompanyNameReversed(String statusProjectFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByProjectNameReversed(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByProjectName(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDatePeopleStartWorkReversed(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDatePeopleStartWork(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByStatusReversed(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByStatus(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDateCreateReversed(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDateCreate(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDelegateReversed(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDelegate(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByCompanyNameReversed(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByCompanyName(String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByProjectNameReversed(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByProjectName(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDatePeopleStartWorkReversed(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDatePeopleStartWork(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByStatusReversed(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByStatus(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDateCreateReversed(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDateCreate(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDelegateReversed(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDelegate(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByCompanyNameReversed(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByCompanyName(String companyNameFilter,
			String authorCardFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByProjectNameReversed(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByProjectName(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDatePeopleStartWorkReversed(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDatePeopleStartWork(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByStatusReversed(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByStatus(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDateCreateReversed(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDateCreate(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDelegateReversed(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDelegate(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByCompanyNameReversed(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByCompanyName(String companyNameFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByProjectNameReversed(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByProjectName(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDatePeopleStartWorkReversed(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDatePeopleStartWork(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByStatusReversed(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByStatus(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDateCreateReversed(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDateCreate(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDelegateReversed(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDelegate(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByCompanyNameReversed(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByCompanyName(String companyNameFilter,
			String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByProjectNameReversed(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByProjectName(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDatePeopleStartWorkReversed(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDatePeopleStartWork(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByStatusReversed(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByStatus(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDateCreateReversed(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDateCreate(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDelegateReversed(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDelegate(String statusProjectFilter);
	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByCompanyNameReversed(String statusProjectFilter);

	List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByCompanyName(String statusProjectFilter);
}

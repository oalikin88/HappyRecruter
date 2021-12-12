package ru.ibs.trainee.happyrecruter.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTO;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOCreate;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOedit;
import ru.ibs.trainee.happyrecruter.entities.*;
import ru.ibs.trainee.happyrecruter.mapper.ProjectMapper;
import ru.ibs.trainee.happyrecruter.mapper.ProjectMapperTest;
import ru.ibs.trainee.happyrecruter.services.ProjectService;

@RestController
@RequestMapping("project/")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectMapper projectMapper;
	@Autowired
	ProjectMapperTest mapper;
	@Autowired
	Project project;
	@Autowired
	ProjectDTO dto;

	@Tag(name = "Создание проекта", description = "Детальное описание будет позже")
	@PostMapping("create")
	public ResponseEntity<String> create(@RequestBody ProjectDTOedit dto) {

		project = mapper.fromProjectDTOeditToProject(dto);
		projectService.createProject(project);
		return new ResponseEntity<String>("ОК ", HttpStatus.OK); // Подумай! Возврат объекта будет со всеми полями

		// проекта!!!!
	}

	@Tag(name = "Просмотр карточки", description = "Детальное описание будет позже")
	@GetMapping(value = "view/{id}")
	public ProjectDTO show(@PathVariable(name = "id") Long id) {
		// List<Project> listProject = new ArrayList<>();
		// List<ProjectDTO> listDTO = new ArrayList<>();

		project = projectService.openProjects(id);
		// for (Project e : listProject) {
//		dto = projectMapper.projectToProjectDto(project);
		dto = mapper.toProjectDTO(project);
		// listDTO.add(dto);
		// }
		return dto;
	}

	@Transactional
	@Tag(name = "Редактирование карточки", description = "Детальное описание будет позже")
	@PutMapping(value = "view/edit/")
	public ResponseEntity<String> edit(@RequestParam(required = true) Long id, @RequestBody ProjectDTOedit dto) {
//		project = projectMapper.projectDtoToProject(dto);
		projectService.getProject(id);
		project = mapper.fromProjectDTOeditToProject(dto);
		projectService.editProject(project, id);
		return new ResponseEntity<String>("Карточка отредактирована ", HttpStatus.OK);
	}

	@Tag(name = "Удаление карточки", description = "Детальное описание будет позже")
	@PostMapping(value = "view/delete")
	public ResponseEntity<String> delete(@RequestParam(required = true) Long id) {
		project = projectService.getProject(id);
		projectService.deleteProject(project.getId());
		return new ResponseEntity<String>("Карточка удалена", HttpStatus.OK);
	}

	@Tag(name = "Реестр карточек", description = "Реестр карточек - просто get; 'projectName' - сортировка по наименованию проекта; 'projectNameReversed' - сортировка в обратном порядке"
			+ " 'createDate' - сортировка по дате создания проекта; 'createDateReversed' - сортировка в обратном порядке;"
			+ " 'status' - сортировка по статусу проекта; 'statusReversed' - сортировка в обратном порядке;"
			+ " 'peopleStartWorking' - сортировка по дате вывода людей на проект; 'peopleStartWorkingReversed' - сортировка в обратном порядке"
			+ " 'delegate' - сортировка по делегированию; 'delegateReversed' - сортировка в обратном порядке"
			+ " 'companyName' - сортировка по заказчику; 'companyNameReversed' - сортировка в обратном порядке;"
			+ " Фильтр по автору пока не работает;")

	@GetMapping(value = "view/registry/")
	public List<ProjectDTOView> viewRegistryCards(@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(required = false) String companyNameFilter,
			@RequestParam(required = false) String statusProjectFilter,
			@RequestParam(required = false) String authorCardFilter) {

		List<ProjectDTOView> result = projectService.showRegistryCards();

		if (null != companyNameFilter && null != statusProjectFilter && null != authorCardFilter) {
			result = projectService.showRegistryCards(); // Это переделать
		} else if (null != companyNameFilter && null != statusProjectFilter && null == authorCardFilter) {

			if ("projectName".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getProjectName))
						.collect(Collectors.toList());
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getProjectName).reversed())
						.collect(Collectors.toList());
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getDateStartProject))
						.collect(Collectors.toList());
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
						.collect(Collectors.toList());
			} else if ("status".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getStatusValue))
						.collect(Collectors.toList());
			} else if ("statusReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getStatusValue).reversed())
						.collect(Collectors.toList());
			} else if ("createDate".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getDateTimeCreate))
						.collect(Collectors.toList());
			} else if ("createDateReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
						.collect(Collectors.toList());
			} else if ("delegate".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::isDelegated))
						.collect(Collectors.toList());
			} else if ("delegateReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::isDelegated).reversed())
						.collect(Collectors.toList());
			} else if ("companyName".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getCompanyName))
						.collect(Collectors.toList());
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter)
						.stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getCompanyName).reversed())
						.collect(Collectors.toList());
			} else {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter,
						statusProjectFilter);
			}

			result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter,
					statusProjectFilter);
		} else if (null != companyNameFilter && null == statusProjectFilter && null == authorCardFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getProjectName))
						.collect(Collectors.toList());
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getProjectName).reversed())
						.collect(Collectors.toList());
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateStartProject))
						.collect(Collectors.toList());
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
						.collect(Collectors.toList());
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getStatusValue))
						.collect(Collectors.toList());
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getStatusValue).reversed())
						.collect(Collectors.toList());
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateTimeCreate))
						.collect(Collectors.toList());
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
						.collect(Collectors.toList());
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::isDelegated))
						.collect(Collectors.toList());
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::isDelegated).reversed())
						.collect(Collectors.toList());
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getCompanyName))
						.collect(Collectors.toList());
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getCompanyName).reversed())
						.collect(Collectors.toList());
			} else {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter);
			}

		} else if (null != companyNameFilter && null != authorCardFilter && null == statusProjectFilter) {
			result = projectService.showRegistryCards(); // Это переделать
		} else if (null != statusProjectFilter && null != authorCardFilter && null == companyNameFilter) {
			result = projectService.showRegistryCards(); // Это переделать
		} else if (null != statusProjectFilter && null == authorCardFilter && null == companyNameFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getProjectName))
						.collect(Collectors.toList());
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getProjectName).reversed())
						.collect(Collectors.toList());
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateStartProject))
						.collect(Collectors.toList());
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
						.collect(Collectors.toList());
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getStatusValue))
						.collect(Collectors.toList());
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getStatusValue).reversed())
						.collect(Collectors.toList());
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateTimeCreate))
						.collect(Collectors.toList());
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
						.collect(Collectors.toList());
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::isDelegated))
						.collect(Collectors.toList());
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::isDelegated).reversed())
						.collect(Collectors.toList());
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getCompanyName))
						.collect(Collectors.toList());
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getCompanyName).reversed())
						.collect(Collectors.toList());
			} else {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter);
			}

		} else if (null != authorCardFilter && null == statusProjectFilter && null == companyNameFilter) {
			result = projectService.showRegistryCards(); // Это переделать
		} else if (null == companyNameFilter && null == statusProjectFilter && null == authorCardFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewSortByProjectName();
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService.projectDTOViewSortByProjectNameReversed();
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewsSortByStartDate();
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewsSortByStartDateReversed();
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewsSortByStatus();
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewsSortByStatusReversed();
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService.projectDTOViewSortByDatePeopleStartWorking();
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService.projectDTOViewSortByDatePeopleStartWorkingReversed();
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewSortedByDelegate();
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewSortedByDelegateReversed();
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewSortByCompanyName();
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService.projectDTOViewSortByCompanyNameReversed();
			} else {
				result = projectService.showRegistryCards();
			}
		}

		return result;
	}
}

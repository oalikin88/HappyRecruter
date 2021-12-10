package ru.ibs.trainee.happyrecruter.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTO;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOCreate;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.*;
import ru.ibs.trainee.happyrecruter.mapper.ProjectMapper;
import ru.ibs.trainee.happyrecruter.services.ProjectService;

@RestController
@RequestMapping("project/")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectMapper projectMapper;
	@Autowired
	Project project;
	@Autowired
	ProjectDTO dto;

	@Tag(name = "Создание проекта", description = "Детальное описание будет позже")
	@PostMapping("create")
	public ResponseEntity<String> create(@RequestBody ProjectDTOCreate dto) {

		project = projectMapper.projectDtoToProject(dto);
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
		dto = projectMapper.projectToProjectDto(project);
		// listDTO.add(dto);
		// }
		return dto;
	}

	@Transactional
	@Tag(name = "Редактирование карточки", description = "Детальное описание будет позже")
	@PutMapping(value = "view/edit/")
	public ResponseEntity<String> edit(@RequestParam(required = true) Long id, @RequestBody ProjectDTO dto) {
		project = projectMapper.projectDtoToProject(dto);
		projectService.editProject(project);
		return new ResponseEntity<String>("Карточка отредактирована " + project, HttpStatus.OK);
	}

	@Tag(name = "Удаление карточки", description = "Детальное описание будет позже")
	@PostMapping(value = "view/delete")
	public ResponseEntity<String> delete(@RequestParam(required = true) Long id) {
		project = projectService.getProject(id);
		projectService.deleteProject(project.getId());
		return new ResponseEntity<String>("Карточка удалена", HttpStatus.OK);
	}

	@Tag(name = "Реестр карточек", description = "1 - сортировка по дате вывода людей на проект; 2 - сортировка по наименованию проекта; 3 - сортировка в обратном порядке"
												+ " 4 - сортировка по дате открытия; 5 - сортировка в обратном порядке;"
												+ " 6 - сортировка по статусу проекта; 7 - сортировка в обратном порядке;"
												+ " 8 - сортировка по дате вывода людей на проект; 9 - сортировка в обратном порядке"
												+ " 10 - сортировка по делегированию; 11 - сортировка в обратном порядке"
												+ " 12 - сортировка по заказчику; 13 - сортировка в обратном порядке;")
	@GetMapping(value = "view/registry")
	public List<ProjectDTOView> viewRegistryCards(int value) {
		if (value == 1) {
			return projectService.showRegistryCards();
		} else if (value == 2) {
			return projectService.projectDTOViewSortByProjectName();
		} else if (value == 3) {
			return projectService.projectDTOViewSortByProjectNameReversed();
		} else if (value == 4) {
			return projectService.projectDTOViewsSortByStartDate();
		} else if (value == 5) {
			return projectService.projectDTOViewsSortByStartDateReversed();
		} else if (value == 6) {
			return projectService.projectDTOViewsSortByStatus();
		} else if (value == 7) {
			return projectService.projectDTOViewsSortByStatusReversed();
		} else if (value == 8) {
			return projectService.projectDTOViewSortByDatePeopleStartWorking();
		} else if (value == 9) {
			return projectService.projectDTOViewSortByDatePeopleStartWorkingReversed();
		} else if (value == 10) {
			return projectService.projectDTOViewSortedByDelegate();
		} else if (value == 11) {
			return projectService.projectDTOViewSortedByDelegateReversed();
		} else if (value == 12) {
			return projectService.projectDTOViewSortByCompanyName();
		} else {
			return projectService.projectDTOViewSortByCompanyNameReversed();
		}
	}
}

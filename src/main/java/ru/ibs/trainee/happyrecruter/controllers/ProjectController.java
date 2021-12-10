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

	@Tag(name = "Реестр карточек", description = "Детальное описание будет позже")
	@GetMapping(value = "view")
	public List<ProjectDTOView> registry() {
		return projectService.showTest();
	}

	@Tag(name = "Сортировка по имени", description = "Детальное описание будет позже")
	@GetMapping(value = "view/1")
	public List<ProjectDTOView> registrySortByName() {
		return projectService.projectDTOViewSortByName();
	}

	@Tag(name = "Тест", description = "1 - сортировка по дате вывода людей на проект; \n "
	+ " 2 - сортировка по наименовании компании")
	@GetMapping(value = "test/{i}")
	public List<ProjectDTOView> test(@RequestParam(required = true) int value) {
		if (value == 1) {
			return projectService.showTest();
		} else {
			return projectService.projectDTOViewSortByName();
		}
	}

}

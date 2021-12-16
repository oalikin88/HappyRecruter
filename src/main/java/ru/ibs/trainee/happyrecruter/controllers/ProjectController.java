package ru.ibs.trainee.happyrecruter.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTO;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOedit;
import ru.ibs.trainee.happyrecruter.entities.*;
import ru.ibs.trainee.happyrecruter.mapper.ProjectMapperTest;
import ru.ibs.trainee.happyrecruter.repositories.SubjectAreaRepository;
import ru.ibs.trainee.happyrecruter.services.ProjectService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("project/")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectMapperTest mapper;
	@Autowired
	Project project;
	@Autowired
	ProjectDTO dto;
	SubjectAreaRepository subjectAreaRepository;

	@Tag(name = "Создание проекта", description = "Детальное описание будет позже")
	@PostMapping("create")
	public ResponseEntity<ProjectDTOedit> create(@RequestBody ProjectDTOedit dto) {
		project = mapper.fromProjectDTOeditToProject(dto);
		projectService.createProject(project);
		return new ResponseEntity<ProjectDTOedit>(dto, HttpStatus.OK);

	}

	@GetMapping("subjects")
	public List<String> showSubject() {
		return projectService.showSubjects();
	}

	@GetMapping("type1")
	public List<String> showType1() {
		return projectService.showType1();
	}

	@GetMapping("type2")
	public List<String> showType2() {
		return projectService.showType2();
	}

	@GetMapping("type3")
	public List<String> showType3() {
		return projectService.showType3();
	}

	@GetMapping("type4")
	public List<String> showType4() {
		return projectService.showType4();
	}

	@GetMapping("methodologies")
	public List<String> showMethodology() {
		return projectService.showMethodologies();
	}

	@GetMapping("stage")
	public List<String> showStage() {
		return projectService.showStage();
	}

	@GetMapping("pojectStatus")
	public List<String> showStatus() {
		return projectService.showStatus();
	}

	@GetMapping("overtime")
	public List<String> showOvertime() {
		return projectService.showOvertimes();
	}

	@Tag(name = "Просмотр карточки", description = "Детальное описание будет позже")
	@GetMapping(value = "view/{id}")
	public ProjectDTO show(@PathVariable(name = "id") Long id) {
		project = projectService.openProjects(id);
		dto = mapper.toProjectDTO(project);
		return dto;
	}

	@Transactional
	@Tag(name = "Редактирование карточки", description = "Детальное описание будет позже")
	@PutMapping(value = "view/edit/")
	public ResponseEntity<String> edit(@RequestParam(required = true) Long id, @RequestBody ProjectDTOedit dto) {
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

		// Включены фиьтры: по заказчику, по статусу проекта, по автору карточки.
		// Сортировка по условию

		if (null != companyNameFilter && null != statusProjectFilter && null != authorCardFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByProjectName(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByProjectNameReversed(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDateStartPeopleWork(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDateStartPeopleWorkReversed(
								companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByStatus(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByStatusReversed(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCreateDate(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCreateDateReversed(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDelegate(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDelegateReversed(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("companyName".equals(sort)) {
				return projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCompanyName(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else if ("companyNameReversed".equals(sort)) {
				return projectService.projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCompanyNameReversed(
						companyNameFilter, statusProjectFilter, authorCardFilter);
			} else {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter,
						statusProjectFilter, authorCardFilter);
			}

			// Включены фиьтры: по автору, по статусу проекта. Сортировка по условию

		} else if (null == companyNameFilter && null != statusProjectFilter && null != authorCardFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByProjectName(statusProjectFilter,
						authorCardFilter);
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByProjectNameReversed(
						statusProjectFilter, authorCardFilter);
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByDatePeopleStartWork(
						statusProjectFilter, authorCardFilter);
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByDatePeopleStartWorkReversed(
						statusProjectFilter, authorCardFilter);
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByStatus(statusProjectFilter,
						authorCardFilter);
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByStatusReversed(
						statusProjectFilter, authorCardFilter);
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByDateCreate(statusProjectFilter,
						authorCardFilter);
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByDateCreateReversed(
						statusProjectFilter, authorCardFilter);
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByDelegate(statusProjectFilter,
						authorCardFilter);
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByDelegateReversed(
						statusProjectFilter, authorCardFilter);
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByCompanyName(statusProjectFilter,
						authorCardFilter);
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusAndAuthorAndSortByCompanyNameReversed(
						statusProjectFilter, authorCardFilter);
			} else {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter,
						statusProjectFilter);
			}

			// Включены фиьтры: по заказчику. Сортировка по условию

		} else if (null != companyNameFilter && null == statusProjectFilter && null == authorCardFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndSortByProjectName(companyNameFilter);
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndSortByProjectNameReversed(companyNameFilter);
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndSortByDatePeopleStartWork(companyNameFilter);
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndSortByDatePeopleStartWorkReversed(companyNameFilter);
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndSortByStatus(companyNameFilter);
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndSortByStatusReversed(companyNameFilter);
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndSortByDateCreate(companyNameFilter);
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndSortByDateCreateReversed(companyNameFilter);
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndSortByDelegate(companyNameFilter);
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndSortByDelegateReversed(companyNameFilter);
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndSortByCompanyName(companyNameFilter);
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndSortByCompanyNameReversed(companyNameFilter);
			} else {
				result = projectService.projectDTOViewFilterByCompanyName(companyNameFilter);
			}

			// Включены фильтры: по заказчику, по автору карточки. Сортировка по условию

		} else if (null != companyNameFilter && null != authorCardFilter && null == statusProjectFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByProjectName(
						companyNameFilter, authorCardFilter);
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByProjectNameReversed(
						companyNameFilter, authorCardFilter);
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByDatePeopleStartWork(
						companyNameFilter, authorCardFilter);
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByDatePeopleStartWorkReversed(
						companyNameFilter, authorCardFilter);
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByStatus(companyNameFilter,
						authorCardFilter);
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByStatusReversed(
						companyNameFilter, authorCardFilter);
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByDateCreate(companyNameFilter,
						authorCardFilter);
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByDateCreateReversed(
						companyNameFilter, authorCardFilter);
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByDelegate(companyNameFilter,
						authorCardFilter);
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByDelegateReversed(
						companyNameFilter, authorCardFilter);
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByCompanyName(
						companyNameFilter, authorCardFilter);
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthorAndSortByCompanyNameReversed(
						companyNameFilter, authorCardFilter);
			} else {
				result = projectService.projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter);
			}

			// Включены фильтры: по статусу проекта, по автору карточки. Сортировка по
			// условию

		} else if (null != statusProjectFilter && null == authorCardFilter && null != companyNameFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByProjectName(
						companyNameFilter, statusProjectFilter);
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByProjectNameReversed(
						companyNameFilter, statusProjectFilter);
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDatePeopleStartWork(
						companyNameFilter, statusProjectFilter);
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDatePeopleStartWorkReversed(
								companyNameFilter, statusProjectFilter);
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByStatus(
						companyNameFilter, statusProjectFilter);
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByStatusReversed(
						companyNameFilter, statusProjectFilter);
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDateCreate(
						companyNameFilter, statusProjectFilter);
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDateCreateReversed(
						companyNameFilter, statusProjectFilter);
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDelegate(
						companyNameFilter, statusProjectFilter);
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDelegateReversed(
						companyNameFilter, statusProjectFilter);
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByCompanyName(
						companyNameFilter, statusProjectFilter);
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByCompanyNameReversed(
						companyNameFilter, statusProjectFilter);
			} else {
				result = projectService.projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter,
						statusProjectFilter);
			}

			// Включены фильтры: по статусу проекта. Сортировка по условию

		} else if (null != statusProjectFilter && null == authorCardFilter && null == companyNameFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProjectAndSortByProjectName(statusProjectFilter);
				;
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByStatusProjectAndSortByProjectNameReversed(statusProjectFilter);
				;
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByStatusProjectAndSortByDatePeopleStartWork(statusProjectFilter);
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByStatusProjectAndSortByDatePeopleStartWorkReversed(statusProjectFilter);
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProjectAndSortByStatus(statusProjectFilter);
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProjectAndSortByStatusReversed(statusProjectFilter);
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProjectAndSortByDateCreate(statusProjectFilter);
			} else if ("createDateReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByStatusProjectAndSortByDateCreateReversed(statusProjectFilter);
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProjectAndSortByDelegate(statusProjectFilter);
			} else if ("delegateReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByStatusProjectAndSortByDelegateReversed(statusProjectFilter);
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewFilterByStatusProjectAndSortByCompanyName(statusProjectFilter);
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByStatusProjectAndSortByCompanyNameReversed(statusProjectFilter);
			} else {
				result = projectService.projectDTOViewFilterByStatusProject(statusProjectFilter);
			}

			// Включены фиьтры: по автору карточки. Сортировка по условию

		} else if (null != authorCardFilter && null == statusProjectFilter && null == companyNameFilter) {

			if ("projectName".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByProjectName(authorCardFilter);
			} else if ("projectNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByProjectNameReversed(authorCardFilter);
			} else if ("peopleStartWorking".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByDatePeopleStartWork(authorCardFilter);
			} else if ("peopleStartWorkingReversed".equals(sort)) {
				result = projectService
						.projectDTOViewFilterByAuthorAndSortByDatePeopleStartWorkReversed(authorCardFilter);
			} else if ("status".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByStatus(authorCardFilter);
			} else if ("statusReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByStatusReversed(authorCardFilter);
			} else if ("createDate".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByDateCreate(authorCardFilter);
			} else if ("createDateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByDateCreateReversed(authorCardFilter);
			} else if ("delegate".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByDelegate(authorCardFilter);
			} else if ("delegateReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByDelegateReversed(authorCardFilter);
			} else if ("companyName".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByCompanyName(authorCardFilter);
			} else if ("companyNameReversed".equals(sort)) {
				result = projectService.projectDTOViewFilterByAuthorAndSortByCompanyNameReversed(authorCardFilter);
			} else {
				result = projectService.projectDTOViewFilterByAuthor(authorCardFilter);
			}

			// Фильтры не используются. Сортировка по условию

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

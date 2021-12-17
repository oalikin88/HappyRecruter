package ru.ibs.trainee.happyrecruter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.*;
import ru.ibs.trainee.happyrecruter.mapper.ProjectDTOViewMapper;
import ru.ibs.trainee.happyrecruter.repositories.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	StaffListRepository staffListRepository;
	@Autowired
	Type1Repository type1Repository;
	@Autowired
	Type2Repository type2Repository;
	@Autowired
	Type3Repository type3Repository;
	@Autowired
	Type4Repository type4Repository;
	@Autowired
	MethodologyRepository methodologyRepository;
	@Autowired
	StageRepository stageRepository;
	@Autowired
	OvertimeRepository overtimeRepository;
	@Autowired
	SubjectAreaRepository subjectAreaRepository;
	@Autowired
	ProjectStatusRepository projectStatusRepository;
	@Autowired
	MemberTeamRepository memberTeamRepository;


	// Создание карточки

	@Override
	public Project createProject(Project project) {

		project.setDateTimeCreate(LocalDateTime.now());

		ProjectStatus status = projectStatusRepository.findByStatusValue(project.getProjectStatus().getStatusValue());
		project.setProjectStatus(status);

		SubjectArea subjectArea = subjectAreaRepository.findByNameIs(project.getSubjectArea().getName());
		project.setSubjectArea(subjectArea);

		Overtime overtime = overtimeRepository.findByOvertimeNameIs(project.getIdOvertime().getOvertimeName());
		project.setIdOvertime(overtime);

		Stage stage = stageRepository.findByStageNameIs(project.getIdStage().getStageName());
		project.setIdStage(stage);

		Methodology methodology = methodologyRepository
				.findByMethodologyNameIs(project.getIdMethodology().getMethodologyName());
		project.setIdMethodology(methodology);

		Type1 type1 = type1Repository.findByTypeIs(project.getIdType1().getType());
		Type2 type2 = type2Repository.findByTypeIs(project.getIdType2().getType());
		Type3 type3 = type3Repository.findByTypeIs(project.getIdType3().getType());
		Type4 type4 = type4Repository.findByTypeIs(project.getIdType4().getType());

		project.setIdType1(type1);
		project.setIdType2(type2);
		project.setIdType3(type3);
		project.setIdType4(type4);

		project.getMemberTeam1().setStaffList(staffListRepository.findStaffListByStaffNameIs("Аналитики"));
		project.getMemberTeam2().setStaffList(staffListRepository.findStaffListByStaffNameIs("Front"));
		project.getMemberTeam3().setStaffList(staffListRepository.findStaffListByStaffNameIs("Back"));
		project.getMemberTeam4().setStaffList(staffListRepository.findStaffListByStaffNameIs("Fullstack"));
		project.getMemberTeam5().setStaffList(staffListRepository.findStaffListByStaffNameIs("Тестировщики"));
		project.getMemberTeam6().setStaffList(staffListRepository.findStaffListByStaffNameIs("Техписы"));

		return projectRepository.save(project);
	}

	// Просмотр карточки

	@Override
	public Project openProjects(Long id) {
		return projectRepository.findById(id).get();
	}

	// Словарь предметной области

	public List<String> showSubjects() {
		List<String> list = new ArrayList<>();
		subjectAreaRepository.findAll().stream().sorted(Comparator.comparing(SubjectArea::getName))
				.forEach(o -> list.add(o.getName()));
		return list;
	}
	
	// Словари типов проекта
	
	public List<String> showType1() {
		List<String> list = new ArrayList<>();
		type1Repository.findAll().stream().sorted(Comparator.comparing(Type1::getType)).forEach(o -> list.add(o.getType()));
		return list;
	}

	public List<String> showType2() {
		List<String> list = new ArrayList<>();
		type2Repository.findAll().stream().sorted(Comparator.comparing(Type2::getType)).forEach(o -> list.add(o.getType()));
		return list;
	}
	public List<String> showType3() {
		List<String> list = new ArrayList<>();
		type3Repository.findAll().stream().sorted(Comparator.comparing(Type3::getType)).forEach(o -> list.add(o.getType()));
		return list;
	}
	public List<String> showType4() {
		List<String> list = new ArrayList<>();
		type4Repository.findAll().stream().sorted(Comparator.comparing(Type4::getType)).forEach(o -> list.add(o.getType()));
		return list;
	}
	
	public List<String> showMethodologies() {
		List<String> list = new ArrayList<>();
		methodologyRepository.findAll().stream().sorted(Comparator.comparing(Methodology::getMethodologyName)).forEach(o -> list.add(o.getMethodologyName()));
		return list;
	}
	
	public List<String> showStage() {
		List<String> list = new ArrayList<>();
		stageRepository.findAll().stream().forEach(o -> list.add(o.getStageName()));
		return list;
	}
	public List<String> showStatus() {
		List<String> list = new ArrayList<>();
		projectStatusRepository.findAll().forEach(o -> list.add(o.getStatusValue()));
		return list;
	}
	public List<String> showOvertimes() {
		List<String> list = new ArrayList<>();
		overtimeRepository.findAll().stream().sorted(Comparator.comparing(Overtime::getOvertimeName)).forEach(o -> list.add(o.getOvertimeName()));
		return list;
	}
	
	// Проверка есть ли карточка в БД

	public Project getProject(Long id) {
		Project project = null;

		try {
			if (null != id && !projectRepository.findById(id).isEmpty()) {
				project = projectRepository.findById(id).get();
			} else {
				throw new RuntimeException("Id не найден!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return project;
	}

	// Редактирование карточки

	@Override
	public Project editProject(Project project, Long id) {

		Project editProject = projectRepository.findById(id).get();
		if (!project.getCompanyName().equals(editProject.getCompanyName())) {
			editProject.setCompanyName(project.getCompanyName());
		}
		if (!project.getProjectName().equals(editProject.getProjectName())) {
			editProject.setProjectName(project.getProjectName());
		}
		if (!project.getDescription().equals(editProject.getDescription())) {
			editProject.setDescription(project.getDescription());
		}
		if (!project.getLocation().equals(editProject.getLocation())) {
			editProject.setLocation(project.getLocation());
		}
		if (!project.getFunctionalArea().equals(editProject.getFunctionalArea())) {
			editProject.setFunctionalArea(project.getFunctionalArea());
		}
		if (!project.getProjectTasks().equals(editProject.getProjectTasks())) {
			editProject.setProjectTasks(project.getProjectTasks());
		}
		if (!project.getDateCloseProject().equals(editProject.getDateCloseProject())) {
			editProject.setDateCloseProject(project.getDateCloseProject());
		}
		if (!project.getTechnologies().equals(editProject.getTechnologies())) {
			editProject.setTechnologies(project.getTechnologies());
		}
		if (project.getStakeholders() != editProject.getStakeholders()) {
			editProject.setStakeholders(project.getStakeholders());
		}
		if (!project.getProcedureEnteringStaff().equals(editProject.getProcedureEnteringStaff())) {
			editProject.setProcedureEnteringStaff(project.getProcedureEnteringStaff());
		}
		if (project.isDocumentated() != editProject.isDocumentated()) {
			editProject.setDocumentated(project.isDocumentated());
		}
		if (project.isInWorked() == editProject.isInWorked()) {
			editProject.setInWorked(editProject.isInWorked());
		}
		if (project.isDelegated() != editProject.isDelegated()) {
			editProject.setDelegated(project.isDelegated());
		}
		if (project.isProductProject() != editProject.isProductProject()) {
			editProject.setProductProject(project.isProductProject());
		}
		if (project.isHasDesigners() != editProject.isHasDesigners()) {
			editProject.setHasDesigners(project.isHasDesigners());
		}
		if (project.getHasAnotherSpecialists() != editProject.getHasAnotherSpecialists()) {
			editProject.setHasAnotherSpecialists(project.getHasAnotherSpecialists());
		}

		if (!project.getMemberTeam1().equals(editProject.getMemberTeam1())) {
			editProject.getMemberTeam1().setCountHired(project.getMemberTeam1().getCountHired());
			editProject.getMemberTeam1().setCountNeeds(project.getMemberTeam1().getCountNeeds());
			editProject.getMemberTeam1().setDateStartProject(project.getMemberTeam1().getDateStartProject());
		}
		if (!project.getMemberTeam2().equals(editProject.getMemberTeam2())) {
			editProject.getMemberTeam2().setCountHired(project.getMemberTeam2().getCountHired());
			editProject.getMemberTeam2().setCountNeeds(project.getMemberTeam2().getCountNeeds());
			editProject.getMemberTeam2().setDateStartProject(project.getMemberTeam2().getDateStartProject());
		}
		if (!project.getMemberTeam3().equals(editProject.getMemberTeam3())) {
			editProject.getMemberTeam3().setCountHired(project.getMemberTeam3().getCountHired());
			editProject.getMemberTeam3().setCountNeeds(project.getMemberTeam3().getCountNeeds());
			editProject.getMemberTeam3().setDateStartProject(project.getMemberTeam3().getDateStartProject());
		}
		if (!project.getMemberTeam4().equals(editProject.getMemberTeam4())) {
			editProject.getMemberTeam4().setCountHired(project.getMemberTeam4().getCountHired());
			editProject.getMemberTeam4().setCountNeeds(project.getMemberTeam4().getCountNeeds());
			editProject.getMemberTeam4().setDateStartProject(project.getMemberTeam4().getDateStartProject());
		}
		if (!project.getMemberTeam5().equals(editProject.getMemberTeam5())) {
			editProject.getMemberTeam5().setCountHired(project.getMemberTeam5().getCountHired());
			editProject.getMemberTeam5().setCountNeeds(project.getMemberTeam5().getCountNeeds());
			editProject.getMemberTeam5().setDateStartProject(project.getMemberTeam5().getDateStartProject());
		}
		if (!project.getMemberTeam6().equals(editProject.getMemberTeam6())) {
			editProject.getMemberTeam6().setCountHired(project.getMemberTeam6().getCountHired());
			editProject.getMemberTeam6().setCountNeeds(project.getMemberTeam6().getCountNeeds());
			editProject.getMemberTeam6().setDateStartProject(project.getMemberTeam6().getDateStartProject());
		}
		if (!project.getProjectStatus().equals(editProject.getProjectStatus())) {
			editProject.setProjectStatus(projectStatusRepository
					.findProjectStatusByStatusValue(project.getProjectStatus().getStatusValue()));
		}

		if (!project.getSubjectArea().equals(editProject.getSubjectArea())) {
			editProject.setSubjectArea(subjectAreaRepository.findByNameIs(project.getSubjectArea().getName()));
		}

		if (!project.getIdOvertime().equals(editProject.getIdOvertime())) {
			editProject
					.setIdOvertime(overtimeRepository.findByOvertimeNameIs(project.getIdOvertime().getOvertimeName()));
		}

		if (!project.getIdStage().equals(editProject.getIdStage())) {
			editProject.setIdStage(stageRepository.findByStageNameIs(project.getIdStage().getStageName()));
		}

		if (!project.getIdMethodology().equals(editProject.getIdMethodology())) {
			editProject.setIdMethodology(
					methodologyRepository.findByMethodologyNameIs(project.getIdMethodology().getMethodologyName()));
		}

		if (!project.getIdType1().equals(editProject.getIdType1())) {
			editProject.setIdType1(type1Repository.findByTypeIs(project.getIdType1().getType()));
		}
		if (!project.getIdType2().equals(editProject.getIdType2())) {
			editProject.setIdType2(type2Repository.findByTypeIs(project.getIdType2().getType()));
		}
		if (!project.getIdType3().equals(editProject.getIdType3())) {
			editProject.setIdType3(type3Repository.findByTypeIs(project.getIdType3().getType()));
		}
		if (!project.getIdType4().equals(editProject.getIdType4())) {
			editProject.setIdType4(type4Repository.findByTypeIs(project.getIdType4().getType()));
		}

		return projectRepository.save(editProject);
	}

	// Удаление карточки

	@Override
	public void deleteProject(Long id) {

		projectRepository.deleteById(id);
	}

	@Autowired
	ProjectDTOView projectDTOView;
	@Autowired
	ProjectDTOViewMapper dtoViewMapper;

	// Реестр карточек

	@Override
	public List<ProjectDTOView> showRegistryCards() {
		List<ProjectDTOView> listDTO = new ArrayList<>();

		List<Project> list = projectRepository.findAll();
		for (Project pr : list) {
			projectDTOView = dtoViewMapper.projectToProjectDTOView(pr);
			List<LocalDate> listDate = new ArrayList<>();
			if (pr.getMemberTeam1().getDateStartProject() != null) {
				listDate.add(pr.getMemberTeam1().getDateStartProject());
			}
			if (pr.getMemberTeam2().getDateStartProject() != null) {
				listDate.add(pr.getMemberTeam2().getDateStartProject());
			}
			if (pr.getMemberTeam3().getDateStartProject() != null) {
				listDate.add(pr.getMemberTeam3().getDateStartProject());
			}
			if (pr.getMemberTeam4().getDateStartProject() != null) {
				listDate.add(pr.getMemberTeam4().getDateStartProject());
			}
			if (pr.getMemberTeam5().getDateStartProject() != null) {
				listDate.add(pr.getMemberTeam5().getDateStartProject());
			}
			if (pr.getMemberTeam6().getDateStartProject() != null) {
				listDate.add(pr.getMemberTeam6().getDateStartProject());
			}
			if (!listDate.isEmpty()) {
				Collections.sort(listDate);
				projectDTOView.setDateStartProject(listDate.get(0));

			}
			listDTO.add(projectDTOView);

		}
		return listDTO;
	}

	// Фильтр по заказчику, статусу и автору карточки

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(String companyNameFilter,
			String statusProjectFilter, String authorCardFilter) {
		return showRegistryCards().stream()
				.filter(t -> t.getCompanyName().toLowerCase().contains(companyNameFilter.toLowerCase()))
				.filter(t -> t.getStatusValue().toLowerCase().contains(statusProjectFilter.toLowerCase()))
				.filter(t -> t.getFio().toLowerCase().contains(authorCardFilter.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCompanyName(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getCompanyName))
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCompanyNameReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getCompanyName).reversed())
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDelegateReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::isDelegated).reversed())
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDelegate(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream().sorted(java.util.Comparator.comparing(ProjectDTOView::isDelegated))
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCreateDateReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByCreateDate(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getDateTimeCreate))
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByStatusReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getStatusValue).reversed())
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByStatus(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getStatusValue))
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDateStartPeopleWorkReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByDateStartPeopleWork(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getDateStartProject))
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByProjectNameReversed(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream()
						.sorted(java.util.Comparator.comparing(ProjectDTOView::getProjectName).reversed())
						.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusAndAuthorAndSortByProjectName(
			String companyNameFilter, String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilterAndAuthor(companyNameFilter, statusProjectFilter,
				authorCardFilter).stream().sorted(java.util.Comparator.comparing(ProjectDTOView::getProjectName))
						.collect(Collectors.toList());
	}

	// Фильтр по статусу и автору карточки

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthor(String statusProjectFilter,
			String authorCardFilter) {
		return showRegistryCards().stream()
				.filter(t -> t.getStatusValue().toLowerCase().contains(statusProjectFilter.toLowerCase()))
				.filter(t -> t.getFio().toLowerCase().contains(authorCardFilter.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByProjectName(String statusProjectFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDatePeopleStartWork(
			String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDatePeopleStartWorkReversed(
			String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByProjectNameReversed(
			String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByStatus(String statusProjectFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByStatusReversed(String statusProjectFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDateCreate(String statusProjectFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDateCreateReversed(
			String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDelegate(String statusProjectFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByDelegateReversed(
			String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByCompanyName(String statusProjectFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusAndAuthorAndSortByCompanyNameReversed(
			String statusProjectFilter, String authorCardFilter) {
		return projectDTOViewFilterByStatusAndAuthor(statusProjectFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName).reversed()).collect(Collectors.toList());
	}

	// Фильтр по автору и сортировка

	public List<ProjectDTOView> projectDTOViewFilterByAuthor(String authorCardFilter) {
		return showRegistryCards().stream()
				.filter(t -> t.getFio().toLowerCase().contains(authorCardFilter.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByProjectName(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByProjectNameReversed(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDatePeopleStartWork(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDatePeopleStartWorkReversed(
			String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByStatus(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByStatusReversed(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDateCreate(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDateCreateReversed(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDelegate(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByDelegateReversed(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByCompanyName(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByAuthorAndSortByCompanyNameReversed(String authorCardFilter) {
		return projectDTOViewFilterByAuthor(authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName).reversed()).collect(Collectors.toList());
	}

	// Фильтр по заказчику и автору карточки

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthor(String companyNameFilter,
			String authorCardFilter) {
		return showRegistryCards().stream()
				.filter(t -> t.getCompanyName().toLowerCase().contains(companyNameFilter.toLowerCase()))
				.filter(t -> t.getFio().toLowerCase().contains(authorCardFilter.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByProjectName(String companyNameFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByProjectNameReversed(
			String companyNameFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDatePeopleStartWork(
			String companyNameFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDatePeopleStartWorkReversed(
			String companyNameFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByStatus(String companyNameFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByStatusReversed(
			String companyNameFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDateCreate(String companyNameFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDateCreateReversed(
			String companyNameFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDelegate(String companyNameFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByDelegateReversed(
			String companyNameFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByCompanyName(String companyNameFilter,
			String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndAuthorAndSortByCompanyNameReversed(
			String companyNameFilter, String authorCardFilter) {
		return projectDTOViewFilterByCompanyNameAndAuthor(companyNameFilter, authorCardFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName).reversed()).collect(Collectors.toList());
	}

	// Фильтр по заказчику и статусу

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilter(String companyNameFilter,
			String statusProjectFilter) {
		return showRegistryCards().stream()
				.filter(t -> t.getCompanyName().toLowerCase().contains(companyNameFilter.toLowerCase()))
				.filter(t -> t.getStatusValue().toLowerCase().contains(statusProjectFilter.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByProjectName(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByProjectNameReversed(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDatePeopleStartWork(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDatePeopleStartWorkReversed(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByStatus(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByStatusReversed(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDateCreate(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDateCreateReversed(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDelegate(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByDelegateReversed(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByCompanyName(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilterAndSortByCompanyNameReversed(
			String companyNameFilter, String statusProjectFilter) {
		return projectDTOViewFilterByCompanyNameAndStatusFilter(companyNameFilter, statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName).reversed()).collect(Collectors.toList());
	}
	// Фильтр по заказчику

	public List<ProjectDTOView> projectDTOViewFilterByCompanyName(String companyNameFilter) {
		return showRegistryCards().stream()
				.filter(t -> t.getCompanyName().toLowerCase().contains(companyNameFilter.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByProjectName(String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByProjectNameReversed(
			String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDatePeopleStartWork(
			String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDatePeopleStartWorkReversed(
			String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByStatus(String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByStatusReversed(String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDateCreate(String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDateCreateReversed(String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDelegate(String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByDelegateReversed(String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByCompanyName(String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndSortByCompanyNameReversed(
			String companyNameFilter) {
		return projectDTOViewFilterByCompanyName(companyNameFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName).reversed()).collect(Collectors.toList());
	}
	// Фильтр по статусу

	public List<ProjectDTOView> projectDTOViewFilterByStatusProject(String statusProjectFilter) {
		return showRegistryCards().stream()
				.filter(t -> t.getStatusValue().toLowerCase().contains(statusProjectFilter.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByProjectName(String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByProjectNameReversed(
			String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getProjectName).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDatePeopleStartWork(
			String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDatePeopleStartWorkReversed(
			String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByStatus(String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByStatusReversed(String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getStatusValue).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDateCreate(String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDateCreateReversed(
			String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDelegate(String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByDelegateReversed(
			String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::isDelegated).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByCompanyName(String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName)).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewFilterByStatusProjectAndSortByCompanyNameReversed(
			String statusProjectFilter) {
		return projectDTOViewFilterByStatusProject(statusProjectFilter).stream()
				.sorted(Comparator.comparing(ProjectDTOView::getCompanyName).reversed()).collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewSortByProjectName() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getProjectName))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewSortByProjectNameReversed() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getProjectName).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewsSortByStartDate() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewsSortByStartDateReversed() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getDateTimeCreate).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewsSortByStatus() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getStatusValue))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewsSortByStatusReversed() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getStatusValue).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewSortByDatePeopleStartWorking() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getDateStartProject))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewSortByDatePeopleStartWorkingReversed() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getDateStartProject).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewSortedByDelegate() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::isDelegated))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewSortedByDelegateReversed() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::isDelegated).reversed())
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewSortByCompanyName() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getCompanyName))
				.collect(Collectors.toList());
	}

	public List<ProjectDTOView> projectDTOViewSortByCompanyNameReversed() {
		return showRegistryCards().stream().sorted(Comparator.comparing(ProjectDTOView::getCompanyName).reversed())
				.collect(Collectors.toList());
	}

}

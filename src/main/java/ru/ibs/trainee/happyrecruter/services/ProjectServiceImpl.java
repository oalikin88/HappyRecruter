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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManagerFactory;

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

	@Autowired
	EntityManagerFactory emf;

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

	@Override
	public Project openProjects(Long id) {

		return projectRepository.findById(id).get();

		// List<Project> list = new ArrayList<>();
		// if (id != null) {
		// list.add(projectRepository.findById(id).get());
		// list;
		// } else {
		// projectRepository.findAll().forEach(e -> list.add(e));
		// return list;
		// }
	}

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
		if (!project.getProjectStatus().getStatusValue().equals(editProject.getProjectStatus().getStatusValue())) {
			editProject.setProjectStatus(projectStatusRepository.findProjectStatusByStatusValue(project.getProjectStatus().getStatusValue()));
		}

		if (!project.getSubjectArea().getName().equals(editProject.getSubjectArea().getName())) {
			editProject.setSubjectArea(subjectAreaRepository.findByNameIs(project.getSubjectArea().getName()));
		}

		if (!project.getIdOvertime().getOvertimeName().equals(editProject.getIdOvertime().getOvertimeName())) {
			editProject
					.setIdOvertime(overtimeRepository.findByOvertimeNameIs(project.getIdOvertime().getOvertimeName()));
		}

		if (!project.getIdStage().getStageName().equals(editProject.getIdStage().getStageName())) {
			editProject.setIdStage(stageRepository.findByStageNameIs(project.getIdStage().getStageName()));
		}

		if (!project.getIdMethodology().getMethodologyName()
				.equals(editProject.getIdMethodology().getMethodologyName())) {
			editProject.setIdMethodology(
					methodologyRepository.findByMethodologyNameIs(project.getIdMethodology().getMethodologyName()));
		}

		if (!project.getIdType1().getType().equals(editProject.getIdType1().getType())) {
			editProject.setIdType1(type1Repository.findByTypeIs(project.getIdType1().getType()));
		}
		if (!project.getIdType2().getType().equals(editProject.getIdType2().getType())) {
			editProject.setIdType2(type2Repository.findByTypeIs(project.getIdType2().getType()));
		}
		if (!project.getIdType3().getType().equals(editProject.getIdType3().getType())) {
			editProject.setIdType3(type3Repository.findByTypeIs(project.getIdType3().getType()));
		}
		if (!project.getIdType4().getType().equals(editProject.getIdType4().getType())) {
			editProject.setIdType4(type4Repository.findByTypeIs(project.getIdType4().getType()));
		}

		return projectRepository.save(editProject);
	}

	@Override
	public void deleteProject(Long id) {

		projectRepository.deleteById(id);
	}

	@Autowired
	ProjectDTOView projectDTOView;
	@Autowired
	ProjectDTOViewMapper dtoViewMapper;

	@Override
	public List<ProjectDTOView> showRegistryCards() {
		List<ProjectDTOView> listDTO = new ArrayList<>();

		List<Project> list = projectRepository.findAll();
		for (Project pr : list) {
			projectDTOView = dtoViewMapper.projectToProjectDTOView(pr);
			List<LocalDate> listDate = new ArrayList<>();
			listDate.add(pr.getMemberTeam1().getDateStartProject());
			listDate.add(pr.getMemberTeam2().getDateStartProject());
			listDate.add(pr.getMemberTeam3().getDateStartProject());
			listDate.add(pr.getMemberTeam4().getDateStartProject());
			listDate.add(pr.getMemberTeam5().getDateStartProject());
			listDate.add(pr.getMemberTeam6().getDateStartProject());
			Collections.sort(listDate);
			projectDTOView.setDateStartProject(listDate.get(0));
			listDTO.add(projectDTOView);
		}
		return listDTO;
	}
	
	public List<ProjectDTOView> projectDTOViewFilterByCompanyNameAndStatusFilter(String companyNameFilter, String statusProjectFilter) {
		return showRegistryCards().stream().filter(t -> t.getCompanyName().equals(companyNameFilter)).filter(t -> t.getStatusValue().equals(statusProjectFilter))
				.collect(Collectors.toList());
	}
	
	public List<ProjectDTOView> projectDTOViewFilterByCompanyName(String companyNameFilter) {
		return showRegistryCards().stream().filter(t -> t.getCompanyName().equals(companyNameFilter)).collect(Collectors.toList());
	}
	public List<ProjectDTOView> projectDTOViewFilterByStatusProject(String statusProjectFilter) {
		return showRegistryCards().stream().filter(t -> t.getStatusValue().equals(statusProjectFilter)).collect(Collectors.toList());
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

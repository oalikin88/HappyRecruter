package ru.ibs.trainee.happyrecruter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.*;
import ru.ibs.trainee.happyrecruter.repositories.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

		ProjectStatus status = projectStatusRepository.findByNameIs(project.getProjectStatus().getName());
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
		
//		List<Project> list = new ArrayList<>();
//		if (id != null) {
//			list.add(projectRepository.findById(id).get());
// list;
//		} else {
//			projectRepository.findAll().forEach(e -> list.add(e));
//			return list;
//		}
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
	public Project editProject(Project project) {

		Project editProject = projectRepository.findById(project.getId()).get();

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
		if (project.isHasAnotherSpecialists() != editProject.isHasAnotherSpecialists()) {
			editProject.setHasAnotherSpecialists(project.isHasAnotherSpecialists());
		}

		if (!project.getMemberTeam1().equals(editProject.getMemberTeam1())) {
			editProject.setMemberTeam1(project.getMemberTeam1());
		}
		if (!project.getMemberTeam2().equals(editProject.getMemberTeam2())) {
			editProject.setMemberTeam2(project.getMemberTeam2());
		}
		if (!project.getMemberTeam3().equals(editProject.getMemberTeam3())) {
			editProject.setMemberTeam3(project.getMemberTeam3());
		}
		if (!project.getMemberTeam4().equals(editProject.getMemberTeam4())) {
			editProject.setMemberTeam4(project.getMemberTeam4());
		}
		if (!project.getMemberTeam5().equals(editProject.getMemberTeam5())) {
			editProject.setMemberTeam5(project.getMemberTeam5());
		}
		if (!project.getMemberTeam6().equals(editProject.getMemberTeam6())) {
			editProject.setMemberTeam6(project.getMemberTeam6());
		}
		if (!project.getProjectStatus().getName().equals(editProject.getProjectStatus().getName())) {
			editProject.setProjectStatus(projectStatusRepository.findByNameIs(project.getProjectStatus().getName()));
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

	@Override
	public List<ProjectDTOView> JPQLQuery() {
		EntityManager em = emf.createEntityManager();
		// em.getTransaction().begin( );

		Query query = em.createQuery("select proj.id proj.companyName proj.dateTimeCreate proj.projectName"
				+ "proj.projectStatus proj.isDelegated from Project as proj MemberTeam as membr join"
				+ "membr.dateStartProject as dateSt");
		@SuppressWarnings("unchecked")
		List<ProjectDTOView> list = (List<ProjectDTOView>) query.getResultList();
		em.close();

		return list;

	}

	/*
	 * public List<StudentEntity> studentAllData() { return
	 * studentrepository.findAll(); }
	 */
	
	public Collection<Project> showProjects() {
			
		
		return projectRepository.findAllQuery();
	}

}

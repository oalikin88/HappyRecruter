package ru.ibs.trainee.happyrecruter.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTO;
import ru.ibs.trainee.happyrecruter.entities.MemberTeam;
import ru.ibs.trainee.happyrecruter.entities.Methodology;
import ru.ibs.trainee.happyrecruter.entities.Overtime;
import ru.ibs.trainee.happyrecruter.entities.Project;
import ru.ibs.trainee.happyrecruter.entities.ProjectStatus;
import ru.ibs.trainee.happyrecruter.entities.StaffList;
import ru.ibs.trainee.happyrecruter.entities.Stage;
import ru.ibs.trainee.happyrecruter.entities.SubjectArea;
import ru.ibs.trainee.happyrecruter.entities.Type1;
import ru.ibs.trainee.happyrecruter.entities.Type2;
import ru.ibs.trainee.happyrecruter.entities.Type3;
import ru.ibs.trainee.happyrecruter.entities.Type4;

@Component
public class ProjectMapper {
	@Autowired
	Type1 type1;
	
	
	public Project projectDtoToProject(ProjectDTO dto) {
		Project project = new Project();
		project.setId(dto.getId());
		project.setDateTimeCreate(dto.getDateTimeCreate());
		project.setCompanyName(dto.getCompanyName());
		project.setProjectName(dto.getProjectName());
		project.setLocation(dto.getLocation());		
		project.setFunctionalArea(dto.getFunctionalArea());
		project.setDescription(dto.getDescription());
		project.setProjectTasks(dto.getProjectTasks());
		project.setDateCloseProject(dto.getDateCloseProject());
		project.setStakeholders(dto.getStakeholders());
		project.setProcedureEnteringStaff(dto.getProcedureEnteringStaff());
		project.setTechnologies(dto.getTechnologies());
		project.setDocumentated(dto.isDocumentated());
		project.setWorkHome(dto.isWorkHome());
		project.setDelegated(dto.isDelegated());
		project.setProductProject(dto.isProductProject());
		project.setHasDesigners(dto.isHasDesigners());
		project.setHasAnotherSpecialists(dto.isHasAnotherSpecialists());
		project.setProjectStatus(new ProjectStatus(dto.getIdProjectStatus(), dto.getProjectStatus()));
		project.setIdStage(new Stage(dto.getIdStage(), dto.getStage()));
		project.setIdOvertime(new Overtime(dto.getIdOvertime(), dto.getOvertime()));
		project.setIdMethodology(new Methodology(dto.getIdMethodology(), dto.getMethodology()));
		project.setSubjectArea(new SubjectArea(dto.getIdSubjectArea(), dto.getSubjectArea()));
		
	
		project.setIdType1(new Type1(dto.getIdType1(), dto.getType1()));
		project.setIdType2(new Type2(dto.getIdType2(), dto.getType2()));
		project.setIdType3(new Type3(dto.getIdType3(), dto.getType3()));
		project.setIdType4(new Type4(dto.getIdType4(), dto.getType4()));
		project.setMemberTeam1(new MemberTeam(dto.getIdMemberTeam1(), dto.getCountNeeds1(), dto.getCountHired1(),
				dto.getDateStartProject1()));
		project.setMemberTeam2(new MemberTeam(dto.getIdMemberTeam2(), dto.getCountNeeds2(), dto.getCountHired2(),
				dto.getDateStartProject2()));
		project.setMemberTeam3(new MemberTeam(dto.getIdMemberTeam3(), dto.getCountNeeds3(), dto.getCountHired3(),
				dto.getDateStartProject3()));
		project.setMemberTeam4(new MemberTeam(dto.getIdMemberTeam4(), dto.getCountNeeds4(), dto.getCountHired4(),
				dto.getDateStartProject4()));
		project.setMemberTeam5(new MemberTeam(dto.getIdMemberTeam5(), dto.getCountNeeds5(), dto.getCountHired5(),
				dto.getDateStartProject5()));
		project.setMemberTeam6(new MemberTeam(dto.getIdMemberTeam6(), dto.getCountNeeds6(), dto.getCountHired6(),
				dto.getDateStartProject6()));
		
		return project;
	}
	
	public ProjectDTO projectToProjectDto(Project project) {
		ProjectDTO dto = new ProjectDTO();
		dto.setId(project.getId());
		dto.setDateTimeCreate(project.getDateTimeCreate());
		dto.setCompanyName(project.getCompanyName());
		dto.setProjectName(project.getProjectName());
		dto.setLocation(project.getLocation());		
		dto.setFunctionalArea(project.getFunctionalArea());
		dto.setDescription(project.getDescription());
		dto.setProjectTasks(project.getProjectTasks());
		dto.setDateCloseProject(project.getDateCloseProject());
		dto.setStakeholders(project.getStakeholders());
		dto.setProcedureEnteringStaff(project.getProcedureEnteringStaff());
		dto.setTechnologies(project.getTechnologies());
		dto.setDocumentated(project.isDocumentated());
		dto.setWorkHome(project.isWorkHome());
		dto.setDelegated(project.isDelegated());
		dto.setProductProject(project.isProductProject());
		dto.setHasDesigners(project.isHasDesigners());
		dto.setHasAnotherSpecialists(project.isHasAnotherSpecialists());
		
		dto.setIdProjectStatus(project.getProjectStatus().getId());
		dto.setProjectStatus(project.getProjectStatus().getName());
		
		dto.setIdStage(project.getIdStage().getId());
		dto.setStage(project.getIdStage().getStageName());
		
		dto.setIdOvertime(project.getIdOvertime().getId());
		dto.setOvertime(project.getIdOvertime().getOvertimeName());
		
		dto.setIdMethodology(project.getIdMethodology().getId());
		dto.setMethodology(project.getIdMethodology().getMethodologyName());
		
		dto.setIdSubjectArea(project.getSubjectArea().getId());
		dto.setSubjectArea(project.getSubjectArea().getName());
		
		dto.setIdType1(project.getIdType1().getId());
		dto.setType1(project.getIdType1().getType());
			
		dto.setIdType2(project.getIdType2().getId());
		dto.setType2(project.getIdType2().getType());		
		
		dto.setIdType3(project.getIdType3().getId());
		dto.setType3(project.getIdType3().getType());
		
		dto.setIdType4(project.getIdType4().getId());
		dto.setType4(project.getIdType4().getType());
		
		dto.setIdMemberTeam1(project.getMemberTeam1().getId());
		dto.setCountHired1(project.getMemberTeam1().getCountHired());
		dto.setCountNeeds1(project.getMemberTeam1().getCountNeeds());
		
		dto.setIdMemberTeam2(project.getMemberTeam2().getId());
		dto.setCountHired2(project.getMemberTeam2().getCountHired());
		dto.setCountNeeds2(project.getMemberTeam2().getCountNeeds());
		
		dto.setIdMemberTeam3(project.getMemberTeam3().getId());
		dto.setCountHired3(project.getMemberTeam3().getCountHired());
		dto.setCountNeeds3(project.getMemberTeam3().getCountNeeds());
		
		dto.setIdMemberTeam4(project.getMemberTeam4().getId());
		dto.setCountHired4(project.getMemberTeam4().getCountHired());
		dto.setCountNeeds4(project.getMemberTeam4().getCountNeeds());
		
		dto.setIdMemberTeam5(project.getMemberTeam5().getId());
		dto.setCountHired5(project.getMemberTeam5().getCountHired());
		dto.setCountNeeds5(project.getMemberTeam5().getCountNeeds());
		
		dto.setIdMemberTeam6(project.getMemberTeam6().getId());
		dto.setCountHired6(project.getMemberTeam6().getCountHired());
		dto.setCountNeeds6(project.getMemberTeam6().getCountNeeds());
		
		
		dto.setDateStartProject1(project.getMemberTeam1().getDateStartProject());
		dto.setDateStartProject2(project.getMemberTeam2().getDateStartProject());
		dto.setDateStartProject3(project.getMemberTeam3().getDateStartProject());
		dto.setDateStartProject4(project.getMemberTeam4().getDateStartProject());
		dto.setDateStartProject5(project.getMemberTeam5().getDateStartProject());
		dto.setDateStartProject6(project.getMemberTeam6().getDateStartProject());
		
		return dto;
	}
	
	public Project projectDtoToProjectEdit(ProjectDTO dto) {
		Project project = new Project();
		project.setId(dto.getId());
		project.setDateTimeCreate(dto.getDateTimeCreate());
		project.setCompanyName(dto.getCompanyName());
		project.setProjectName(dto.getProjectName());
		project.setLocation(dto.getLocation());		
		project.setFunctionalArea(dto.getFunctionalArea());
		project.setDescription(dto.getDescription());
		project.setProjectTasks(dto.getProjectTasks());
		project.setDateCloseProject(dto.getDateCloseProject());
		project.setStakeholders(dto.getStakeholders());
		project.setProcedureEnteringStaff(dto.getProcedureEnteringStaff());
		project.setTechnologies(dto.getTechnologies());
		project.setDocumentated(dto.isDocumentated());
		project.setWorkHome(dto.isWorkHome());
		project.setDelegated(dto.isDelegated());
		project.setProductProject(dto.isProductProject());
		project.setHasDesigners(dto.isHasDesigners());
		project.setHasAnotherSpecialists(dto.isHasAnotherSpecialists());
		project.setProjectStatus(new ProjectStatus(dto.getIdProjectStatus(), dto.getProjectStatus()));
		project.setIdStage(new Stage(dto.getIdStage(), dto.getStage()));
		project.setIdOvertime(new Overtime(dto.getIdOvertime(), dto.getOvertime()));
		project.setIdMethodology(new Methodology(dto.getIdMethodology(), dto.getMethodology()));
		project.setSubjectArea(new SubjectArea(dto.getIdSubjectArea(), dto.getSubjectArea()));
		
	
		project.setIdType1(new Type1(dto.getIdType1(), dto.getType1()));
		project.setIdType2(new Type2(dto.getIdType2(), dto.getType2()));
		project.setIdType3(new Type3(dto.getIdType3(), dto.getType3()));
		project.setIdType4(new Type4(dto.getIdType4(), dto.getType4()));
		
		project.setMemberTeam1(new MemberTeam(dto.getIdMemberTeam1(), dto.getCountNeeds1(), dto.getCountHired1(),
				dto.getDateStartProject1()));
		project.setMemberTeam2(new MemberTeam(dto.getIdMemberTeam2(), dto.getCountNeeds2(), dto.getCountHired2(),
				dto.getDateStartProject2()));
		project.setMemberTeam3(new MemberTeam(dto.getIdMemberTeam3(), dto.getCountNeeds3(), dto.getCountHired3(),
				dto.getDateStartProject3()));
		project.setMemberTeam4(new MemberTeam(dto.getIdMemberTeam4(), dto.getCountNeeds4(), dto.getCountHired4(),
				dto.getDateStartProject4()));
		project.setMemberTeam5(new MemberTeam(dto.getIdMemberTeam5(), dto.getCountNeeds5(), dto.getCountHired5(),
				dto.getDateStartProject5()));
		project.setMemberTeam6(new MemberTeam(dto.getIdMemberTeam6(), dto.getCountNeeds6(), dto.getCountHired6(),
				dto.getDateStartProject6()));
		
		return project;
	}

}

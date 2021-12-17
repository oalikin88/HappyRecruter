package ru.ibs.trainee.happyrecruter.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTO;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOedit;
import ru.ibs.trainee.happyrecruter.entities.Project;

@Component
public class ProjectMapperTest {

	public ProjectDTO toProjectDTO(Project project) {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<Project, ProjectDTO>() {
			@Override
			protected void configure() {
				map().setType1(source.getIdType1().getType());
				map().setType2(source.getIdType2().getType());
				map().setType3(source.getIdType3().getType());
				map().setType4(source.getIdType4().getType());
				map().setIdType1(source.getIdType1().getId());
				map().setIdType2(source.getIdType2().getId());
				map().setIdType3(source.getIdType3().getId());
				map().setIdType4(source.getIdType4().getId());
				map().setSubjectArea(source.getSubjectArea().getName());
				map().setIdSubjectArea(source.getSubjectArea().getId());
				
				
			}
		});
		return mapper.map(project, ProjectDTO.class);
	}
	
	
	public ProjectDTOedit toProjectDTOedit(Project project) {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<Project, ProjectDTOedit>() {
			@Override
			protected void configure() {
				map().setType1(source.getIdType1().getType());
				map().setType2(source.getIdType2().getType());
				map().setType3(source.getIdType3().getType());
				map().setType4(source.getIdType4().getType());
				map().setSubjectArea(source.getSubjectArea().getName());
			}
		});
		return mapper.map(project, ProjectDTOedit.class);
	}
	public Project fromProjectDTOeditToProject(ProjectDTOedit dto) {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<ProjectDTOedit, Project>() {
			@Override
			protected void configure() {
				map().getIdType1().setType(source.getType1());
				map().getIdType2().setType(source.getType2());
				map().getIdType3().setType(source.getType3());
				map().getIdType4().setType(source.getType4());
				map().getIdStage().setStageName(source.getStage());
				map().getSubjectArea().setName(source.getSubjectArea());
				map().getIdOvertime().setOvertimeName(source.getOvertime());
				map().getIdMethodology().setMethodologyName(source.getMethodology());
				map().getMemberTeam1().setCountHired(source.getCountHired1());
				map().getMemberTeam2().setCountHired(source.getCountHired2());
				map().getMemberTeam3().setCountHired(source.getCountHired3());
				map().getMemberTeam4().setCountHired(source.getCountHired4());
				map().getMemberTeam5().setCountHired(source.getCountHired5());
				map().getMemberTeam6().setCountHired(source.getCountHired6());
				map().getMemberTeam1().setCountNeeds(source.getCountNeeds1());
				map().getMemberTeam2().setCountNeeds(source.getCountNeeds2());
				map().getMemberTeam3().setCountNeeds(source.getCountNeeds3());
				map().getMemberTeam4().setCountNeeds(source.getCountNeeds4());
				map().getMemberTeam5().setCountNeeds(source.getCountNeeds5());
				map().getMemberTeam6().setCountNeeds(source.getCountNeeds6());
				map().getMemberTeam1().setDateStartProject(source.getDateStartProject1());
				map().getMemberTeam2().setDateStartProject(source.getDateStartProject2());
				map().getMemberTeam3().setDateStartProject(source.getDateStartProject3());
				map().getMemberTeam4().setDateStartProject(source.getDateStartProject4());
				map().getMemberTeam5().setDateStartProject(source.getDateStartProject5());
				map().getMemberTeam6().setDateStartProject(source.getDateStartProject6());
				map().getProjectStatus().setStatusValue(source.getProjectStatus());
				
			}
		});
		return mapper.map(dto, Project.class);
	}
	
	
}

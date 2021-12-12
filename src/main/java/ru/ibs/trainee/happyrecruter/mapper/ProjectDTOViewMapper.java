package ru.ibs.trainee.happyrecruter.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.Project;

@Component
public class ProjectDTOViewMapper {

	public ProjectDTOView projectToProjectDTOView(Project project) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(project, ProjectDTOView.class);
	}

}

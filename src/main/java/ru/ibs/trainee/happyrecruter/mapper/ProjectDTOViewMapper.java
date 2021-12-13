package ru.ibs.trainee.happyrecruter.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import ru.ibs.trainee.happyrecruter.dto.ProjectDTO;
import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.Project;

@Component
public class ProjectDTOViewMapper {

	public ProjectDTOView projectToProjectDTOView(Project project) {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<Project, ProjectDTOView>() {
			@Override
			protected void configure() {
				map().setFio(source.getUser().getFio());
				
			}
		});
		return mapper.map(project, ProjectDTOView.class);
	}

}

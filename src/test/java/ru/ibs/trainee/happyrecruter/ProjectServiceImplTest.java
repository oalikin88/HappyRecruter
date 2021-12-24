package ru.ibs.trainee.happyrecruter;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ru.ibs.trainee.happyrecruter.dto.ProjectDTOView;
import ru.ibs.trainee.happyrecruter.entities.Project;
import ru.ibs.trainee.happyrecruter.repositories.ProjectRepository;
import ru.ibs.trainee.happyrecruter.services.ProjectService;

@SpringBootTest
class ProjectServiceImplTest {

	Project project;

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectService projectService;

	@BeforeEach
	void prepare() {
		project = new Project(false, true, false, "Test", "TestProject", "Moscow", "Some description",
				"Some description", "Some tasks", LocalDateTime.now(), LocalDate.now().plusWeeks(2), 5,
				"Some description", true, false, "Some technologies", false, true, true, "maybe", null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null);
		System.out.println("BeforeEach: Project " + project.getProjectName() + " was created");

	}

	@Test
	void createProjectTest() {
		System.out.println("Test: " + this + " started.");
		int size = projectRepository.findAll().size();
		projectService.createProject(project);
		assertTrue(projectRepository.findAll().size() == size + 1);
		assertNotNull(project.getProjectName());

	}

	@Test
	void deleteProjectTest() {
		projectRepository.save(project);
		int size1 = projectRepository.findAll().size();

		Long id = projectRepository.findAll().stream()
				.filter(e -> e.getCompanyName().toLowerCase().contains("Test".toLowerCase())).findAny()
				.map(e -> e.getId()).get();

		projectService.deleteProject(id);

		int size2 = projectRepository.findAll().size();
		assertEquals(size1 - 1, size2);

	}

	@Test
	void deleteProjectThrowExceptionTest() {

		Long id = 777777L;

		assertThrows(NoSuchElementException.class, () -> {
			projectService.deleteProject(id);
		});
	}

	@Test
	void showRegistryCardsTest() {
		List<ProjectDTOView> listDTO = new ArrayList<>();
		listDTO = projectService.showRegistryCards();
		assertTrue(!listDTO.isEmpty());
	}
	
	@Test
	void openProjectTest() {
		projectRepository.save(project);
		Long id = projectRepository.findAll().stream()
				.filter(e -> e.getCompanyName().toLowerCase().contains("Test".toLowerCase())).findAny()
				.map(e -> e.getId()).get();
		Project testProject = projectService.openProjects(id);
		assertNotNull(testProject);
		assertNotNull(testProject.getId());
		
	}
	

	

	
	

	@AfterEach
	void deleteDataFromDataBase() {
		if (projectRepository.findAll().stream()
				.anyMatch(e -> e.getCompanyName().toLowerCase().contains("Test".toLowerCase()))) {
			Long id = projectRepository.findAll().stream()
					.filter(e -> e.getCompanyName().toLowerCase().contains("Test".toLowerCase())).findAny()
					.map(e -> e.getId()).get();
			projectRepository.deleteById(id);
			System.out.println("AfterEach: Project " + project.getProjectName() + " was deleted.");
		}
	}

}

package ru.ibs.trainee.happyrecruter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ibs.trainee.happyrecruter.entities.IbsStaff;
import ru.ibs.trainee.happyrecruter.entities.Project;
import ru.ibs.trainee.happyrecruter.repositories.IbsStaffRepository;
import ru.ibs.trainee.happyrecruter.repositories.ProjectRepository;

@SpringBootApplication
public class HappyRecruterApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HappyRecruterApplication.class, args);

        IbsStaffRepository ibsStaffRepository = context.getBean(IbsStaffRepository.class);
        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);

        IbsStaff ibs1 = new IbsStaff(null, "Петр Петров", "УП", "IT");
        ibsStaffRepository.save(ibs1);

        Project project = new Project();
        projectRepository.save(project);



    }

}

package ru.ibs.trainee.happyrecruter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ibs.trainee.happyrecruter.entities.*;
import ru.ibs.trainee.happyrecruter.repositories.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HappyRecruterApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HappyRecruterApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);
        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);
        StaffListRepository staffListRepository = context.getBean(StaffListRepository.class);
        ProjectStatusRepository projectStatusRepository = context.getBean(ProjectStatusRepository.class);
        Type1Repository type1Repository = context.getBean(Type1Repository.class);
        Type2Repository type2Repository = context.getBean(Type2Repository.class);
        Type3Repository type3Repository = context.getBean(Type3Repository.class);
        Type4Repository type4Repository = context.getBean(Type4Repository.class);

/*        Type1 type1 = new Type1(null, "Фикс");
        Type2 type2 = new Type2(null, "ПО");
        Type3 type3 = new Type3(null, "MVP");
        Type4 type4 = new Type4(null, "Новая система");*/

        Type1 type1 = new Type1(null, "T&M");
        Type2 type2 = new Type2(null, "ПАК");
        Type3 type3 = new Type3(null, "Полный функционал");
        Type4 type4 = new Type4(null, "Модернизация системы");

        type1Repository.save(type1);
        type2Repository.save(type2);
        type3Repository.save(type3);
        type4Repository.save(type4);

//        ProjectStatus draft = new ProjectStatus(null, "draft");
//        ProjectStatus inWork = new ProjectStatus(null, "inWork");
//        ProjectStatus archive = new ProjectStatus(null, "archive");
//
//        projectStatusRepository.save(draft);
//        projectStatusRepository.save(inWork);
//        projectStatusRepository.save(archive);

/*        StaffList analyst = new StaffList(null, "analyst");
        StaffList front = new StaffList(null, "front");
        StaffList back = new StaffList(null, "back");
        StaffList fullstack = new StaffList(null, "fullstack");
        StaffList tester = new StaffList(null, "tester");
        StaffList techwr = new StaffList(null, "techwr");


        staffListRepository.save(analyst);
        staffListRepository.save(front);
        staffListRepository.save(back);
        staffListRepository.save(fullstack);
        staffListRepository.save(tester);
        staffListRepository.save(techwr);*/



/*        Person ibs1 = new Person(null, "ivan", "qwrty", "ivan", new Role(null, "admin"));
        userRepository.save(ibs1);

        Project project = new Project();
        projectRepository.save(project);*/



    }

}

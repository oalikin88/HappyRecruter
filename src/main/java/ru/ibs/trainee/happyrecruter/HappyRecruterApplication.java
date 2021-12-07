package ru.ibs.trainee.happyrecruter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ru.ibs.trainee.happyrecruter.entities.Methodology;
import ru.ibs.trainee.happyrecruter.entities.Overtime;
import ru.ibs.trainee.happyrecruter.entities.Person;
import ru.ibs.trainee.happyrecruter.entities.ProjectStatus;
import ru.ibs.trainee.happyrecruter.entities.StaffList;
import ru.ibs.trainee.happyrecruter.entities.Stage;
import ru.ibs.trainee.happyrecruter.entities.SubjectArea;
import ru.ibs.trainee.happyrecruter.entities.Type1;
import ru.ibs.trainee.happyrecruter.entities.Type2;
import ru.ibs.trainee.happyrecruter.entities.Type3;
import ru.ibs.trainee.happyrecruter.entities.Type4;
import ru.ibs.trainee.happyrecruter.repositories.*;



@SpringBootApplication
public class HappyRecruterApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HappyRecruterApplication.class, args);

        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);
        StaffListRepository staffListRepository = context.getBean(StaffListRepository.class);
        ProjectStatusRepository projectStatusRepository = context.getBean(ProjectStatusRepository.class);
        Type1Repository type1Repository = context.getBean(Type1Repository.class);
        Type2Repository type2Repository = context.getBean(Type2Repository.class);
        Type3Repository type3Repository = context.getBean(Type3Repository.class);
        Type4Repository type4Repository = context.getBean(Type4Repository.class);
        SubjectAreaRepository subjectAreaRepository = context.getBean(SubjectAreaRepository.class);
        MethodologyRepository methodologyRepository = context.getBean(MethodologyRepository.class);
        OvertimeRepository overtimeRepository = context.getBean(OvertimeRepository.class);
        StageRepository stageRepository = context.getBean(StageRepository.class);


		/*
		 * Methodology agile = new Methodology(null, "Agile"); Methodology watefoll =
		 * new Methodology(null, "Watefoll"); methodologyRepository.save(agile);
		 * methodologyRepository.save(watefoll);
		 * 
		 * Overtime sometimes = new Overtime(null, "Иногда"); Overtime always = new
		 * Overtime(null, "Постоянно"); Overtime not = new Overtime(null, "Нет");
		 * overtimeRepository.save(sometimes); overtimeRepository.save(always);
		 * overtimeRepository.save(not);
		 * 
		 * Stage initiation = new Stage(null, "Стадия инициации"); Stage begin = new
		 * Stage(null, "Начало"); Stage middle = new Stage(null, "Середина"); Stage
		 * finalize = new Stage(null, "Завершающая"); stageRepository.save(initiation);
		 * stageRepository.save(begin); stageRepository.save(middle);
		 * stageRepository.save(finalize);
		 * 
		 * 
		 * 
		 * 
		 * SubjectArea medicine = new SubjectArea(null, "Медицина"); SubjectArea
		 * education = new SubjectArea(null, "Образование"); SubjectArea construction =
		 * new SubjectArea(null, "Строительство"); SubjectArea trade = new
		 * SubjectArea(null, "Торговля"); SubjectArea economics = new SubjectArea(null,
		 * "Экономика"); SubjectArea management = new SubjectArea(null, "Управление");
		 * SubjectArea gkh = new SubjectArea(null, "ЖКХ"); SubjectArea banking = new
		 * SubjectArea(null, "Банковская сфера"); SubjectArea oilIndustry = new
		 * SubjectArea(null, "Нефтяная отрасль");
		 * 
		 * subjectAreaRepository.save(medicine); subjectAreaRepository.save(education);
		 * subjectAreaRepository.save(construction); subjectAreaRepository.save(trade);
		 * subjectAreaRepository.save(economics);
		 * subjectAreaRepository.save(management); subjectAreaRepository.save(gkh);
		 * subjectAreaRepository.save(banking); subjectAreaRepository.save(oilIndustry);
		 */


		/*
		 * Type1 type1 = new Type1(null, "Fixed Price"); Type2 type2 = new Type2(null,
		 * "ПО"); Type3 type3 = new Type3(null, "MVP"); Type4 type4 = new Type4(null,
		 * "Новая система");
		 */

		
//		  Type1 type1 = new Type1(null, "T&M"); Type2 type2 = new Type2(null, "ПАК");
//		  Type3 type3 = new Type3(null, "Полный функционал"); Type4 type4 = new
//		  Type4(null, "Модернизация системы");
//		 
//
//        type1Repository.save(type1);
//        type2Repository.save(type2);
//        type3Repository.save(type3);
//        type4Repository.save(type4);

		/*
		 * ProjectStatus draft = new ProjectStatus(null, "Черновик"); ProjectStatus
		 * inWork = new ProjectStatus(null, "В работе"); ProjectStatus archive = new
		 * ProjectStatus(null, "В архиве");
		 * 
		 * projectStatusRepository.save(draft); projectStatusRepository.save(inWork);
		 * projectStatusRepository.save(archive);
		 * 
		 * StaffList analyst = new StaffList(null, "Аналитики"); StaffList front = new
		 * StaffList(null, "Front"); StaffList back = new StaffList(null, "Back");
		 * StaffList fullstack = new StaffList(null, "Fullstack"); StaffList tester =
		 * new StaffList(null, "Тестировщики"); StaffList techwr = new StaffList(null,
		 * "Техписы");
		 * 
		 * 
		 * staffListRepository.save(analyst); staffListRepository.save(front);
		 * staffListRepository.save(back); staffListRepository.save(fullstack);
		 * staffListRepository.save(tester); staffListRepository.save(techwr);
		 */



/*        Person ibs1 = new Person(null, "ivan", "qwrty", "ivan", new Role(null, "admin"));
        userRepository.save(ibs1);

        Project project = new Project();
        projectRepository.save(project);*/

      



    }

}

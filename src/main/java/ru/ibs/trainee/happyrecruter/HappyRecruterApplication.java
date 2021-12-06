package ru.ibs.trainee.happyrecruter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ibs.trainee.happyrecruter.entities.Person;
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


     /*   Methodology agile = new Methodology(null, "Agile");
        Methodology watefoll = new Methodology(null, "Watefoll");
        methodologyRepository.save(agile);
        methodologyRepository.save(watefoll);

        Overtime sometimes = new Overtime(null, "Р�РЅРѕРіРґР°");
        Overtime always = new Overtime(null, "РџРѕСЃС‚РѕСЏРЅРЅРѕ");
        Overtime not = new Overtime(null, "РќРµС‚");
        overtimeRepository.save(sometimes);
        overtimeRepository.save(always);
        overtimeRepository.save(not);

        Stage initiation = new Stage(null, "Р�РЅРёС†РёР°С†РёСЏ");
        Stage begin = new Stage(null, "РќР°С‡Р°Р»Рѕ");
        Stage middle = new Stage(null, "РЎРµСЂРµРґРёРЅР°");
        Stage finalize = new Stage(null, "Р—Р°РІРµСЂС€Р°СЋС‰Р°СЏ");
        stageRepository.save(initiation);
        stageRepository.save(begin);
        stageRepository.save(middle);
        stageRepository.save(finalize);




        SubjectArea medicine = new SubjectArea(null, "РњРµРґРёС†РёРЅР°");
        SubjectArea education = new SubjectArea(null, "РћР±СЂР°Р·РѕРІР°РЅРёРµ");
        SubjectArea construction = new SubjectArea(null, "РЎС‚СЂРѕРёС‚РµР»СЊСЃС‚РІРѕ");
        SubjectArea trade = new SubjectArea(null, "РўРѕСЂРіРѕРІР»СЏ");
        SubjectArea economics = new SubjectArea(null, "Р­РєРѕРЅРѕРјРёРєР°");
        SubjectArea management = new SubjectArea(null, "РЈРїСЂР°РІР»РµРЅРёРµ");
        SubjectArea gkh = new SubjectArea(null, "Р–РљРҐ");
        SubjectArea banking = new SubjectArea(null, "Р‘Р°РЅРєРѕРІСЃРєР°СЏ СЃС„РµСЂР°");
        SubjectArea oilIndustry = new SubjectArea(null, "РќРµС„С‚СЏРЅРЅР°СЏ РѕС‚СЂР°СЃР»СЊ");

        subjectAreaRepository.save(medicine);
        subjectAreaRepository.save(education);
        subjectAreaRepository.save(construction);
        subjectAreaRepository.save(trade);
        subjectAreaRepository.save(economics);
        subjectAreaRepository.save(management);
        subjectAreaRepository.save(gkh);
        subjectAreaRepository.save(banking);
        subjectAreaRepository.save(oilIndustry);*/


 /*       Type1 type1 = new Type1(null, "Р¤РёРєСЃ");
        Type2 type2 = new Type2(null, "РџРћ");
        Type3 type3 = new Type3(null, "MVP");
        Type4 type4 = new Type4(null, "РќРѕРІР°СЏ СЃРёСЃС‚РµРјР°");*/

//        Type1 type1 = new Type1(null, "T&M");
//        Type2 type2 = new Type2(null, "РџРђРљ");
//        Type3 type3 = new Type3(null, "РџРѕР»РЅС‹Р№ С„СѓРЅРєС†РёРѕРЅР°Р»");
//        Type4 type4 = new Type4(null, "РњРѕРґРµСЂРЅРёР·Р°С†РёСЏ СЃРёСЃС‚РµРјС‹");
//
//        type1Repository.save(type1);
//        type2Repository.save(type2);
//        type3Repository.save(type3);
//        type4Repository.save(type4);

/*        ProjectStatus draft = new ProjectStatus(null, "draft");
        ProjectStatus inWork = new ProjectStatus(null, "inWork");
        ProjectStatus archive = new ProjectStatus(null, "archive");

        projectStatusRepository.save(draft);
        projectStatusRepository.save(inWork);
        projectStatusRepository.save(archive);

        StaffList analyst = new StaffList(null, "РђРЅР°Р»РёС‚РёРєРё");
        StaffList front = new StaffList(null, "Front");
        StaffList back = new StaffList(null, "Back");
        StaffList fullstack = new StaffList(null, "Fullstack");
        StaffList tester = new StaffList(null, "РўРµСЃС‚РёСЂРѕРІС‰РёРєРё");
        StaffList techwr = new StaffList(null, "РўРµС…РїРёСЃС‹");


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

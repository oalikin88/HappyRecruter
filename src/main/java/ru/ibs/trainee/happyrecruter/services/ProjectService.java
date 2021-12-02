package ru.ibs.trainee.happyrecruter.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.ibs.trainee.happyrecruter.entities.*;
import ru.ibs.trainee.happyrecruter.repositories.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
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





    public Project createProject (String companyName, String projectName,
                                  String location, String functionalArea, String description,
                                  String projectTasks, LocalDate dateCloseProject,
                                  int stakeholders, String procedureEnteringStaff,
                                  boolean isDocumentated, boolean isWorkHome, String technologies,
                                  boolean isDelegated, boolean isProductProject, boolean hasDesigners,
                                  boolean hasAnotherSpecialists, String stageIn, String overtimeIn,
                                  String methodologyIn, String subjectArea,
                                  String type1In, String type2In, String type3In, String type4In,
                                  float countNeeds1, float countHired1, float countNeeds2, float countHired2, float countNeeds3,
                                  float countHired3, float countNeeds4, float countHired4, float countNeeds5, float countHired5,
                                  float countNeeds6, float countHired6,
                                  LocalDate dateStartProject1, LocalDate dateStartProject2,
                                  LocalDate dateStartProject3, LocalDate dateStartProject4,
                                  LocalDate dateStartProject5,  LocalDate dateStartProject6) {

        Project project = new Project();
        SubjectArea subjectAreaIn = subjectAreaRepository.findByNameIs(subjectArea);
        Overtime overtime = overtimeRepository.findByOvertimeNameIs(overtimeIn);
        Stage stage = stageRepository.findByStageNameIs(stageIn);



        Methodology methodology = methodologyRepository.findByMethodologyNameIs(methodologyIn);

        Type1 type1 = type1Repository.findByTypeIs(type1In);
        Type2 type2 = type2Repository.findByTypeIs(type2In);
        Type3 type3 = type3Repository.findByTypeIs(type3In);
        Type4 type4 = type4Repository.findByTypeIs(type4In);



        MemberTeam analyst = new MemberTeam(null, countNeeds1, countHired1, dateStartProject1);
        MemberTeam front = new MemberTeam(null, countNeeds2, countHired2, dateStartProject2);
        MemberTeam back = new MemberTeam(null, countNeeds3, countHired3, dateStartProject3);
        MemberTeam fullstack = new MemberTeam(null, countNeeds4, countHired4, dateStartProject4);
        MemberTeam tester = new MemberTeam(null, countNeeds5, countHired5, dateStartProject5);
        MemberTeam techwr = new MemberTeam(null, countNeeds6, countHired6, dateStartProject6);

        analyst.setStaffList(staffListRepository.findStaffListByStaffNameIs("analyst"));
        front.setStaffList(staffListRepository.findStaffListByStaffNameIs("front"));
        back.setStaffList(staffListRepository.findStaffListByStaffNameIs("back"));
        fullstack.setStaffList(staffListRepository.findStaffListByStaffNameIs("fullstack"));
        tester.setStaffList(staffListRepository.findStaffListByStaffNameIs("tester"));
        techwr.setStaffList(staffListRepository.findStaffListByStaffNameIs("techwr"));




        project.setSubjectArea(subjectAreaIn);
        project.setCompanyName(companyName);
        project.setProjectName(projectName);
        project.setFunctionalArea(functionalArea);
        project.setDescription(description);
        project.setProjectTasks(projectTasks);
        project.setDateCloseProject(dateCloseProject);
        project.setStakeholders(stakeholders);
        project.setLocation(location);
        project.setProcedureEnteringStaff(procedureEnteringStaff);
        project.setDocumentated(isDocumentated);
        project.setWorkHome(isWorkHome);
        project.setTechnologies(technologies);
        project.setIdStage(stage);
        project.setIdOvertime(overtime);
        project.setDelegated(isDelegated);
        project.setIdMethodology(methodology);
        project.setProductProject(isProductProject);
        project.setHasDesigners(hasDesigners);
        project.setHasAnotherSpecialists(hasAnotherSpecialists);
        project.setIdType1(type1);
        project.setIdType2(type2);
        project.setIdType3(type3);
        project.setIdType4(type4);
        project.setMemberTeam1(analyst);
        project.setMemberTeam2(front);
        project.setMemberTeam3(back);
        project.setMemberTeam4(fullstack);
        project.setMemberTeam5(tester);
        project.setMemberTeam6(techwr);

        return projectRepository.save(project);
    }

    public Object showProject (Long id) {
        return id == null ? projectRepository.findAll() : projectRepository.findById(id);
    }

    public Object editProject(Long idEditProject, String companyName, String projectName,
                              String location, String functionalArea, String description,
                              String projectTasks, LocalDate dateCloseProject,
                              int stakeholders, String procedureEnteringStaff,
                              boolean isDocumentated, boolean isWorkHome, String technologies,
                              boolean isDelegated, boolean isProductProject, boolean hasDesigners,
                              boolean hasAnotherSpecialists, String stageIn, String overtimeIn,
                              String methodologyIn, String subjectArea,
                              String type1In, String type2In, String type3In, String type4In,
                              float countNeeds1, float countHired1, float countNeeds2, float countHired2, float countNeeds3,
                              float countHired3, float countNeeds4, float countHired4, float countNeeds5, float countHired5,
                              float countNeeds6, float countHired6,
                              LocalDate dateStartProject1, LocalDate dateStartProject2,
                              LocalDate dateStartProject3, LocalDate dateStartProject4,
                              LocalDate dateStartProject5,  LocalDate dateStartProject6) {
        Project newProject;
        if(!projectRepository.findById(idEditProject).isEmpty()) {
            newProject = projectRepository.findById(idEditProject).get();
            newProject.setCompanyName(companyName);
            newProject.setProjectName(projectName);
            newProject.setLocation(location);
            newProject.setFunctionalArea(functionalArea);
            newProject.setDescription(description);
            newProject.setProjectTasks(projectTasks);
            newProject.setDateCloseProject(dateCloseProject);
            newProject.setStakeholders(stakeholders);
            newProject.setProcedureEnteringStaff(procedureEnteringStaff);
            newProject.setDocumentated(isDocumentated);
            newProject.setWorkHome(isWorkHome);
            newProject.setTechnologies(technologies);
            newProject.setDelegated(isDelegated);
            newProject.setProductProject(isProductProject);
            newProject.setHasDesigners(hasDesigners);
            newProject.setHasAnotherSpecialists(hasAnotherSpecialists);
       /*     newProject.setIdType1(idType1);
            newProject.setIdType2(idType2);
            newProject.setIdType3(idType3);
            newProject.setIdType4(idType4);
            newProject.setIdOvertime(idOvertime);
            newProject.setIdMethodology(idMethodology);
            newProject.setSubjectArea(subjectArea);
            newProject.setMemberTeam1(memberTeam);
            newProject.setProjectStatus(projectStatus);*/

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return projectRepository.save(newProject);
    }


}

package ru.ibs.trainee.happyrecruter.controllers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.trainee.happyrecruter.entities.*;
import ru.ibs.trainee.happyrecruter.services.ProjectService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("project/")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("create")
    public Project create(String companyName, String projectName, String location, String functionalArea,
                          String description, String projectTasks,
                          @RequestParam(value = "dateCloseProject")
                          @JsonDeserialize LocalDate dateCloseProject,
                          int stakeholders, String procedureEnteringStaff, boolean isDocumentated,
                          boolean isWorkHome, String technologies, boolean isDelegated,
                          boolean isProductProject, boolean hasDesigners, boolean hasAnotherSpecialists, String stage,
                          String overtime, String methodology, String subjectArea,
                          String type1, String type2, String type3, String type4, float countNeeds1,
                          float countHired1, float countNeeds2, float countHired2, float countNeeds3,
                          float countHired3, float countNeeds4, float countHired4, float countNeeds5, float countHired5,
                          float countNeeds6, float countHired6,
                          @RequestParam(value = "dateStartProject1")
                          @JsonDeserialize LocalDate dateStartProject1,
                          @RequestParam(value = "dateStartProject2")
                          @JsonDeserialize LocalDate dateStartProject2,
                          @RequestParam(value = "dateStartProject3")
                          @JsonDeserialize LocalDate dateStartProject3,
                          @RequestParam(value = "dateStartProject4")
                          @JsonDeserialize LocalDate dateStartProject4,
                          @RequestParam(value = "dateStartProject5")
                              @JsonDeserialize LocalDate dateStartProject5,
                          @RequestParam(value = "dateStartProject6")
                              @JsonDeserialize LocalDate dateStartProject6)
    {


        return projectService.createProject(companyName, projectName, location, functionalArea,
                description, projectTasks, dateCloseProject, stakeholders, procedureEnteringStaff,
                isDocumentated, isWorkHome, technologies, isDelegated, isProductProject,
                hasDesigners, hasAnotherSpecialists, stage, overtime, methodology, subjectArea,
                type1, type2, type3, type4, countNeeds1, countHired1, countNeeds2,
                countHired2, countNeeds3, countHired3, countNeeds4, countHired4, countNeeds5, countHired5,
                countNeeds6, countHired6, dateStartProject1, dateStartProject2, dateStartProject3,
                dateStartProject4, dateStartProject5, dateStartProject6);
    }

    @GetMapping(value = "show")
    public Object show(Long id) {
        return projectService.showProject(id);
    }

    @PostMapping(value = "edit/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object edit(@PathVariable (value = "id")Long idEditProject, String companyName, String projectName, String location,
                       String functionalArea, String description, String projectTasks,
                       @RequestParam(value = "dateCloseProject")
                       @JsonDeserialize LocalDate dateCloseProject, int stakeholders,
                       String procedureEnteringStaff, boolean isDocumentated, boolean isWorkHome,
                       String technologies, boolean isDelegated, boolean isProductProject, boolean hasDesigners,
                       boolean hasAnotherSpecialists, String stage, String overtime, String methodology,
                       String subjectArea, String type1, String type2, String type3, String type4, float countNeeds1,
                       float countHired1, float countNeeds2, float countHired2, float countNeeds3,
                       float countHired3, float countNeeds4, float countHired4, float countNeeds5, float countHired5,
                       float countNeeds6, float countHired6,
                       @RequestParam(value = "dateStartProject1")
                           @JsonDeserialize LocalDate dateStartProject1,
                       @RequestParam(value = "dateStartProject2")
                           @JsonDeserialize LocalDate dateStartProject2,
                       @RequestParam(value = "dateStartProject3")
                           @JsonDeserialize LocalDate dateStartProject3,
                       @RequestParam(value = "dateStartProject4")
                           @JsonDeserialize LocalDate dateStartProject4,
                       @RequestParam(value = "dateStartProject5")
                           @JsonDeserialize LocalDate dateStartProject5,
                       @RequestParam(value = "dateStartProject6")
                           @JsonDeserialize LocalDate dateStartProject6){

 return projectService.editProject(idEditProject, companyName, projectName, location, functionalArea, description,
        projectTasks, dateCloseProject, stakeholders, procedureEnteringStaff,
        isDocumentated, isWorkHome, technologies, isDelegated, isProductProject,
        hasDesigners, hasAnotherSpecialists, stage, overtime,
        methodology, subjectArea, type1, type2, type3, type4, countNeeds1, countHired1, countNeeds2, countHired2,
         countNeeds3, countHired3, countNeeds4, countHired4, countNeeds5, countHired5, countNeeds6, countHired6,
         dateStartProject1, dateStartProject2, dateStartProject3, dateStartProject4, dateStartProject5,
         dateStartProject6);
    }
}

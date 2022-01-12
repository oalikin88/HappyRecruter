package ru.ibs.trainee.happyrecruter.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProjectDTOedit {
	@JsonDeserialize
	private LocalDateTime dateTimeCreate;
    private String projectStatus;
    private String companyName;
    private String projectName;
    private String description;    
    private String location;
    private String functionalArea;
    private String projectTasks;
    @JsonDeserialize 
    private LocalDate dateCloseProject;
    private int stakeholders;
    private String procedureEnteringStaff;
    private boolean isDocumentated;
    private boolean isWorkHome;
    private String technologies;
    private boolean isDelegated;
    private boolean isProductProject;
    private boolean hasDesigners;
    private String hasAnotherSpecialists;
    private String stage;
    private String overtime;
    private String methodology;
    private String subjectArea;
    private String type1;   
    private String type2;
    private String type3;
    private String type4;
    private float countNeeds1;
    private float countHired1;
    private LocalDate dateStartProject1;
    private float countNeeds2;
    private float countHired2;
    private LocalDate dateStartProject2;
    private float countNeeds3;
    private float countHired3;
    private LocalDate dateStartProject3;
    private float countNeeds4;
    private float countHired4;
    private LocalDate dateStartProject4;
    private float countNeeds5;
    private float countHired5; 
    private LocalDate dateStartProject5;
    private float countNeeds6;
    private float countHired6;
    private LocalDate dateStartProject6;
    private String email;
	
}

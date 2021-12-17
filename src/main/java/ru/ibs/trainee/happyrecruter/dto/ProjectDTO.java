package ru.ibs.trainee.happyrecruter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProjectDTO {
	private Long id;
	@JsonDeserialize 
	private LocalDateTime DateTimeCreate;
	private Long idProjectStatus;
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
    private Long idStage;
    private String stage;
    private Long idOvertime;
    private String overtime;
    private Long idMethodology;
    private String methodology;
    private Long idSubjectArea;
    private String subjectArea;
    
    private Long idType1;
    private String type1;   
    private Long idType2;
    private String type2;
    private Long idType3;
    private String type3;
    private Long idType4;
    private String type4;

    private Long idMemberTeam1;
    private float countNeeds1;
    private float countHired1;
    @JsonDeserialize 
    private LocalDate dateStartProject1;
    private Long idMemberTeam2;
    private float countNeeds2;
    private float countHired2;
    @JsonDeserialize 
    private LocalDate dateStartProject2;
    private Long idMemberTeam3;
    private float countNeeds3;
    private float countHired3;
    @JsonDeserialize 
    private LocalDate dateStartProject3;
    private Long idMemberTeam4;
    private float countNeeds4;
    private float countHired4;
    @JsonDeserialize 
    private LocalDate dateStartProject4;
    private Long idMemberTeam5;
    private float countNeeds5;
    private float countHired5;
    @JsonDeserialize 
    private LocalDate dateStartProject5;
    private Long idMemberTeam6;
    private float countNeeds6;
    private float countHired6;
    @JsonDeserialize 
    private LocalDate dateStartProject6;
}

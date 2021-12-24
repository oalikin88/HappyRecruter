package ru.ibs.trainee.happyrecruter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table
@NoArgsConstructor
@Data
@Component
public class Project {

  
	@Id
    @GeneratedValue
    private Long id;
    private boolean isDraft;
    private boolean isInWorked;
    private boolean isArchived;
    private String companyName;
    private String projectName;
    private String location;
    private String functionalArea;
    private String description;
    private String projectTasks;
    private LocalDateTime dateTimeCreate;
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
    @ManyToOne
    @JoinColumn(name = "id_type1")
    private Type1 idType1;
    @ManyToOne
    @JoinColumn(name = "id_type2")
    private Type2 idType2;
    @ManyToOne
    @JoinColumn(name = "id_type3")
    private Type3 idType3;
    @ManyToOne
    @JoinColumn(name = "id_type4")
    private Type4 idType4;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_stage")
    private Stage idStage;
    @ManyToOne
    @JoinColumn(name = "id_overtime")
    private Overtime idOvertime;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_methodology")
    private Methodology idMethodology;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "subjectArea_id")
    private SubjectArea subjectArea;
    @ManyToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam1;
    @ManyToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam2;
    @ManyToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam3;
    @ManyToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam4;
    @ManyToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam5;
    @ManyToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam6;
    @ManyToOne
    private ProjectStatus projectStatus;
    
    
	public Project(boolean isDraft, boolean isInWorked, boolean isArchived, String companyName, String projectName,
			String location, String functionalArea, String description, String projectTasks,
			LocalDateTime dateTimeCreate, LocalDate dateCloseProject, int stakeholders, String procedureEnteringStaff,
			boolean isDocumentated, boolean isWorkHome, String technologies, boolean isDelegated,
			boolean isProductProject, boolean hasDesigners, String hasAnotherSpecialists, Type1 idType1, Type2 idType2,
			Type3 idType3, Type4 idType4, Stage idStage, Overtime idOvertime, Methodology idMethodology, User user,
			SubjectArea subjectArea, MemberTeam memberTeam1, MemberTeam memberTeam2, MemberTeam memberTeam3,
			MemberTeam memberTeam4, MemberTeam memberTeam5, MemberTeam memberTeam6, ProjectStatus projectStatus) {
		this.isDraft = isDraft;
		this.isInWorked = isInWorked;
		this.isArchived = isArchived;
		this.companyName = companyName;
		this.projectName = projectName;
		this.location = location;
		this.functionalArea = functionalArea;
		this.description = description;
		this.projectTasks = projectTasks;
		this.dateTimeCreate = dateTimeCreate;
		this.dateCloseProject = dateCloseProject;
		this.stakeholders = stakeholders;
		this.procedureEnteringStaff = procedureEnteringStaff;
		this.isDocumentated = isDocumentated;
		this.isWorkHome = isWorkHome;
		this.technologies = technologies;
		this.isDelegated = isDelegated;
		this.isProductProject = isProductProject;
		this.hasDesigners = hasDesigners;
		this.hasAnotherSpecialists = hasAnotherSpecialists;
		this.idType1 = idType1;
		this.idType2 = idType2;
		this.idType3 = idType3;
		this.idType4 = idType4;
		this.idStage = idStage;
		this.idOvertime = idOvertime;
		this.idMethodology = idMethodology;
		this.user = user;
		this.subjectArea = subjectArea;
		this.memberTeam1 = memberTeam1;
		this.memberTeam2 = memberTeam2;
		this.memberTeam3 = memberTeam3;
		this.memberTeam4 = memberTeam4;
		this.memberTeam5 = memberTeam5;
		this.memberTeam6 = memberTeam6;
		this.projectStatus = projectStatus;
	}
    
    
    
    
    
}

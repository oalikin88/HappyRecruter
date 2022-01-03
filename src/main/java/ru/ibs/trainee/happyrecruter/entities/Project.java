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

	public boolean isDraft() {
		return isDraft;
	}

	public void setDraft(boolean isDraft) {
		this.isDraft = isDraft;
	}

	public boolean isInWorked() {
		return isInWorked;
	}

	public void setInWorked(boolean isInWorked) {
		this.isInWorked = isInWorked;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFunctionalArea() {
		return functionalArea;
	}

	public void setFunctionalArea(String functionalArea) {
		this.functionalArea = functionalArea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProjectTasks() {
		return projectTasks;
	}

	public void setProjectTasks(String projectTasks) {
		this.projectTasks = projectTasks;
	}

	public LocalDateTime getDateTimeCreate() {
		return dateTimeCreate;
	}

	public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
		this.dateTimeCreate = dateTimeCreate;
	}

	public LocalDate getDateCloseProject() {
		return dateCloseProject;
	}

	public void setDateCloseProject(LocalDate dateCloseProject) {
		this.dateCloseProject = dateCloseProject;
	}

	public int getStakeholders() {
		return stakeholders;
	}

	public void setStakeholders(int stakeholders) {
		this.stakeholders = stakeholders;
	}

	public String getProcedureEnteringStaff() {
		return procedureEnteringStaff;
	}

	public void setProcedureEnteringStaff(String procedureEnteringStaff) {
		this.procedureEnteringStaff = procedureEnteringStaff;
	}

	public boolean isDocumentated() {
		return isDocumentated;
	}

	public void setDocumentated(boolean isDocumentated) {
		this.isDocumentated = isDocumentated;
	}

	public boolean isWorkHome() {
		return isWorkHome;
	}

	public void setWorkHome(boolean isWorkHome) {
		this.isWorkHome = isWorkHome;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	public boolean isDelegated() {
		return isDelegated;
	}

	public void setDelegated(boolean isDelegated) {
		this.isDelegated = isDelegated;
	}

	public boolean isProductProject() {
		return isProductProject;
	}

	public void setProductProject(boolean isProductProject) {
		this.isProductProject = isProductProject;
	}

	public boolean isHasDesigners() {
		return hasDesigners;
	}

	public void setHasDesigners(boolean hasDesigners) {
		this.hasDesigners = hasDesigners;
	}

	public String getHasAnotherSpecialists() {
		return hasAnotherSpecialists;
	}

	public void setHasAnotherSpecialists(String hasAnotherSpecialists) {
		this.hasAnotherSpecialists = hasAnotherSpecialists;
	}

	public Type1 getIdType1() {
		return idType1;
	}

	public void setIdType1(Type1 idType1) {
		this.idType1 = idType1;
	}

	public Type2 getIdType2() {
		return idType2;
	}

	public void setIdType2(Type2 idType2) {
		this.idType2 = idType2;
	}

	public Type3 getIdType3() {
		return idType3;
	}

	public void setIdType3(Type3 idType3) {
		this.idType3 = idType3;
	}

	public Type4 getIdType4() {
		return idType4;
	}

	public void setIdType4(Type4 idType4) {
		this.idType4 = idType4;
	}

	public Stage getIdStage() {
		return idStage;
	}

	public void setIdStage(Stage idStage) {
		this.idStage = idStage;
	}

	public Overtime getIdOvertime() {
		return idOvertime;
	}

	public void setIdOvertime(Overtime idOvertime) {
		this.idOvertime = idOvertime;
	}

	public Methodology getIdMethodology() {
		return idMethodology;
	}

	public void setIdMethodology(Methodology idMethodology) {
		this.idMethodology = idMethodology;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SubjectArea getSubjectArea() {
		return subjectArea;
	}

	public void setSubjectArea(SubjectArea subjectArea) {
		this.subjectArea = subjectArea;
	}

	public MemberTeam getMemberTeam1() {
		return memberTeam1;
	}

	public void setMemberTeam1(MemberTeam memberTeam1) {
		this.memberTeam1 = memberTeam1;
	}

	public MemberTeam getMemberTeam2() {
		return memberTeam2;
	}

	public void setMemberTeam2(MemberTeam memberTeam2) {
		this.memberTeam2 = memberTeam2;
	}

	public MemberTeam getMemberTeam3() {
		return memberTeam3;
	}

	public void setMemberTeam3(MemberTeam memberTeam3) {
		this.memberTeam3 = memberTeam3;
	}

	public MemberTeam getMemberTeam4() {
		return memberTeam4;
	}

	public void setMemberTeam4(MemberTeam memberTeam4) {
		this.memberTeam4 = memberTeam4;
	}

	public MemberTeam getMemberTeam5() {
		return memberTeam5;
	}

	public void setMemberTeam5(MemberTeam memberTeam5) {
		this.memberTeam5 = memberTeam5;
	}

	public MemberTeam getMemberTeam6() {
		return memberTeam6;
	}

	public void setMemberTeam6(MemberTeam memberTeam6) {
		this.memberTeam6 = memberTeam6;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
    
    
    
}

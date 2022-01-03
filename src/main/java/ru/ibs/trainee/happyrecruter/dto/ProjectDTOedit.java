package ru.ibs.trainee.happyrecruter.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	public ProjectDTOedit(LocalDateTime dateTimeCreate, String projectStatus, String companyName, String projectName,
			String description, String location, String functionalArea, String projectTasks, LocalDate dateCloseProject,
			int stakeholders, String procedureEnteringStaff, boolean isDocumentated, boolean isWorkHome,
			String technologies, boolean isDelegated, boolean isProductProject, boolean hasDesigners,
			String hasAnotherSpecialists, String stage, String overtime, String methodology, String subjectArea,
			String type1, String type2, String type3, String type4, float countNeeds1, float countHired1,
			LocalDate dateStartProject1, float countNeeds2, float countHired2, LocalDate dateStartProject2,
			float countNeeds3, float countHired3, LocalDate dateStartProject3, float countNeeds4, float countHired4,
			LocalDate dateStartProject4, float countNeeds5, float countHired5, LocalDate dateStartProject5,
			float countNeeds6, float countHired6, LocalDate dateStartProject6) {
		super();
		this.dateTimeCreate = dateTimeCreate;
		this.projectStatus = projectStatus;
		this.companyName = companyName;
		this.projectName = projectName;
		this.description = description;
		this.location = location;
		this.functionalArea = functionalArea;
		this.projectTasks = projectTasks;
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
		this.stage = stage;
		this.overtime = overtime;
		this.methodology = methodology;
		this.subjectArea = subjectArea;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
		this.countNeeds1 = countNeeds1;
		this.countHired1 = countHired1;
		this.dateStartProject1 = dateStartProject1;
		this.countNeeds2 = countNeeds2;
		this.countHired2 = countHired2;
		this.dateStartProject2 = dateStartProject2;
		this.countNeeds3 = countNeeds3;
		this.countHired3 = countHired3;
		this.dateStartProject3 = dateStartProject3;
		this.countNeeds4 = countNeeds4;
		this.countHired4 = countHired4;
		this.dateStartProject4 = dateStartProject4;
		this.countNeeds5 = countNeeds5;
		this.countHired5 = countHired5;
		this.dateStartProject5 = dateStartProject5;
		this.countNeeds6 = countNeeds6;
		this.countHired6 = countHired6;
		this.dateStartProject6 = dateStartProject6;
	}
	public ProjectDTOedit() {
		super();
	}
	public LocalDateTime getDateTimeCreate() {
		return dateTimeCreate;
	}
	public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
		this.dateTimeCreate = dateTimeCreate;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getProjectTasks() {
		return projectTasks;
	}
	public void setProjectTasks(String projectTasks) {
		this.projectTasks = projectTasks;
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
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	public String getMethodology() {
		return methodology;
	}
	public void setMethodology(String methodology) {
		this.methodology = methodology;
	}
	public String getSubjectArea() {
		return subjectArea;
	}
	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	public float getCountNeeds1() {
		return countNeeds1;
	}
	public void setCountNeeds1(float countNeeds1) {
		this.countNeeds1 = countNeeds1;
	}
	public float getCountHired1() {
		return countHired1;
	}
	public void setCountHired1(float countHired1) {
		this.countHired1 = countHired1;
	}
	public LocalDate getDateStartProject1() {
		return dateStartProject1;
	}
	public void setDateStartProject1(LocalDate dateStartProject1) {
		this.dateStartProject1 = dateStartProject1;
	}
	public float getCountNeeds2() {
		return countNeeds2;
	}
	public void setCountNeeds2(float countNeeds2) {
		this.countNeeds2 = countNeeds2;
	}
	public float getCountHired2() {
		return countHired2;
	}
	public void setCountHired2(float countHired2) {
		this.countHired2 = countHired2;
	}
	public LocalDate getDateStartProject2() {
		return dateStartProject2;
	}
	public void setDateStartProject2(LocalDate dateStartProject2) {
		this.dateStartProject2 = dateStartProject2;
	}
	public float getCountNeeds3() {
		return countNeeds3;
	}
	public void setCountNeeds3(float countNeeds3) {
		this.countNeeds3 = countNeeds3;
	}
	public float getCountHired3() {
		return countHired3;
	}
	public void setCountHired3(float countHired3) {
		this.countHired3 = countHired3;
	}
	public LocalDate getDateStartProject3() {
		return dateStartProject3;
	}
	public void setDateStartProject3(LocalDate dateStartProject3) {
		this.dateStartProject3 = dateStartProject3;
	}
	public float getCountNeeds4() {
		return countNeeds4;
	}
	public void setCountNeeds4(float countNeeds4) {
		this.countNeeds4 = countNeeds4;
	}
	public float getCountHired4() {
		return countHired4;
	}
	public void setCountHired4(float countHired4) {
		this.countHired4 = countHired4;
	}
	public LocalDate getDateStartProject4() {
		return dateStartProject4;
	}
	public void setDateStartProject4(LocalDate dateStartProject4) {
		this.dateStartProject4 = dateStartProject4;
	}
	public float getCountNeeds5() {
		return countNeeds5;
	}
	public void setCountNeeds5(float countNeeds5) {
		this.countNeeds5 = countNeeds5;
	}
	public float getCountHired5() {
		return countHired5;
	}
	public void setCountHired5(float countHired5) {
		this.countHired5 = countHired5;
	}
	public LocalDate getDateStartProject5() {
		return dateStartProject5;
	}
	public void setDateStartProject5(LocalDate dateStartProject5) {
		this.dateStartProject5 = dateStartProject5;
	}
	public float getCountNeeds6() {
		return countNeeds6;
	}
	public void setCountNeeds6(float countNeeds6) {
		this.countNeeds6 = countNeeds6;
	}
	public float getCountHired6() {
		return countHired6;
	}
	public void setCountHired6(float countHired6) {
		this.countHired6 = countHired6;
	}
	public LocalDate getDateStartProject6() {
		return dateStartProject6;
	}
	public void setDateStartProject6(LocalDate dateStartProject6) {
		this.dateStartProject6 = dateStartProject6;
	}
    
    
	
}

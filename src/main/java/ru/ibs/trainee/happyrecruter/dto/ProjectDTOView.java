package ru.ibs.trainee.happyrecruter.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
public class ProjectDTOView {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("companyName")
	private String companyName;
	@JsonDeserialize
	@JsonProperty("dateTimeCreate")
	private LocalDateTime dateTimeCreate;
	@JsonProperty("projectName")
	private String projectName;
	@JsonProperty("statusValue")
	private String statusValue;
	@JsonProperty("isDelegated")
	private boolean isDelegated;
	@JsonProperty("fio")
	private String fio;
	@JsonProperty("dateStartProject")
	@JsonDeserialize
	private LocalDate dateStartProject;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectDTOView other = (ProjectDTOView) obj;
		return Objects.equals(companyName, other.companyName)
				&& Objects.equals(dateStartProject, other.dateStartProject)
				&& Objects.equals(dateTimeCreate, other.dateTimeCreate) && Objects.equals(id, other.id)
				&& isDelegated == other.isDelegated && Objects.equals(projectName, other.projectName)
				&& Objects.equals(statusValue, other.statusValue);
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public LocalDateTime getDateTimeCreate() {
		return dateTimeCreate;
	}



	public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
		this.dateTimeCreate = dateTimeCreate;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getStatusValue() {
		return statusValue;
	}



	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}



	public boolean isDelegated() {
		return isDelegated;
	}



	public void setDelegated(boolean isDelegated) {
		this.isDelegated = isDelegated;
	}



	public String getFio() {
		return fio;
	}



	public void setFio(String fio) {
		this.fio = fio;
	}



	public LocalDate getDateStartProject() {
		return dateStartProject;
	}



	public void setDateStartProject(LocalDate dateStartProject) {
		this.dateStartProject = dateStartProject;
	}



	
	
	public ProjectDTOView(Long id, String companyName, LocalDateTime dateTimeCreate, String projectName,
			String statusValue, boolean isDelegated, String fio, LocalDate dateStartProject) {
		this.id = id;
		this.companyName = companyName;
		this.dateTimeCreate = dateTimeCreate;
		this.projectName = projectName;
		this.statusValue = statusValue;
		this.isDelegated = isDelegated;
		this.fio = fio;
		this.dateStartProject = dateStartProject;
	}

	

	public ProjectDTOView() {
		super();
	}



	@Override
	public int hashCode() {
		return Objects.hash(companyName, dateStartProject, dateTimeCreate, id, isDelegated, projectName, statusValue);
	}

	@Override
	public String toString() {
		return "ProjectDTOView [id=" + id + ", companyName=" + companyName + ", dateTimeCreate=" + dateTimeCreate
				+ ", projectName=" + projectName + ", statusValue=" + statusValue + ", isDelegated=" + isDelegated
				+ ", dateStartProject=" + dateStartProject + "]";
	}

}

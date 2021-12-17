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

@AllArgsConstructor
@NoArgsConstructor
@Data
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

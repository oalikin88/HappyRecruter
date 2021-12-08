package ru.ibs.trainee.happyrecruter.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ProjectDTOView {

	private Long id;
	private String companyName;
	@JsonDeserialize
	private LocalDateTime dateTimeCreate;
	private String projectName;
	private String projectStatus;
	private boolean isDelegated;
	@JsonDeserialize
	private LocalDate dateStartProject;
}

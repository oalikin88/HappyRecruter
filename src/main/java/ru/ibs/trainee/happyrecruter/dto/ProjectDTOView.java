package ru.ibs.trainee.happyrecruter.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ProjectDTOView {

	private Long id;
	@JsonDeserialize
	private LocalDateTime DateTimeCreate;
	private String fio;
	private String administrator;
	private String projectName;
	private String projectStatus;
	private boolean isDelegated;
	@JsonDeserialize
	private LocalDate dateStartProject;
}

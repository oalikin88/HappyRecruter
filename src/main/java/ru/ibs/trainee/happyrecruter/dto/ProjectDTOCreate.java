package ru.ibs.trainee.happyrecruter.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProjectDTOCreate extends ProjectDTO {
	@JsonIgnore
	private Long idProjectStatus;
	@JsonIgnore
	private Long id;
	@JsonIgnore
	private Long idStage;
	@JsonIgnore
	private Long idOvertime;
	@JsonIgnore
	private Long idMethodology;
	@JsonIgnore
	private Long idSubjectArea;
	@JsonIgnore
	private Long idType1;
	@JsonIgnore
	private Long idType2;
	@JsonIgnore
	private Long idType3;
	@JsonIgnore
	private Long idType4;
	@JsonIgnore
	private Long idMemberTeam1;
	@JsonIgnore
	private Long idMemberTeam2;
	@JsonIgnore
	private Long idMemberTeam3;
	@JsonIgnore
	private Long idMemberTeam4;
	@JsonIgnore
	private Long idMemberTeam5;
	@JsonIgnore
	private Long idMemberTeam6;
	@JsonIgnore
	private LocalDate dateStartProject6;
	
}

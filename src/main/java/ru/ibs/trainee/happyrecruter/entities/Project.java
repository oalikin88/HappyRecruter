package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table
@AllArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "id_stage")
    private Stage idStage;
    @ManyToOne
    @JoinColumn(name = "id_overtime")
    private Overtime idOvertime;
    @ManyToOne
    @JoinColumn(name = "id_methodology")
    private Methodology idMethodology;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User user1;
    
    @Column(name = "administrator_id")
    private Long administratorId;
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
}

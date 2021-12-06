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
    private boolean hasAnotherSpecialists;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type1")
    private Type1 idType1;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type2")
    private Type2 idType2;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type3")
    private Type3 idType3;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type4")
    private Type4 idType4;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_stage")
    private Stage idStage;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_overtime")
    private Overtime idOvertime;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_methodology")
    private Methodology idMethodology;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id")
    private Person person;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "subjectArea_id")
    private SubjectArea subjectArea;
    @OneToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam1;
    @OneToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam2;
    @OneToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam3;
    @OneToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam4;
    @OneToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam5;
    @OneToOne(cascade = CascadeType.ALL)
    private MemberTeam memberTeam6;
    @OneToOne(cascade = CascadeType.ALL)
    private ProjectStatus projectStatus;
}

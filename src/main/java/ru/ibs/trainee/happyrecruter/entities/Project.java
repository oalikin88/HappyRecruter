package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private IbsStaff ibsStaff;
    @OneToOne
    private ProjectStatus projectStatusName;
    @OneToOne
    private Location idLocation;
    @OneToOne
    private Type1 idType1;
    @OneToOne
    private Type2 idType2;
    @OneToOne
    private Type3 idType3;
    @OneToOne
    private Type4 idType4;
    @OneToOne
    private Stage idStage;
    @OneToOne
    private Overtime idOvertime;
    @OneToOne
    private Methodology idMethodology;

    private LocalDateTime localDateTime;
    private String companyName;
    private String projectName;
    private String subjectArea;
    private String functionalArea;
    private String description;
    private String projectTasks;
    private LocalDate localDate;
    private int stakeholders;
    private LocalDate dateProjectEnter;
    private String procedureEnter;
    private boolean isDocumentated;
    private boolean isWorkHome;
    private String technologies;
    private boolean isDelegated;
    private boolean isProductProject;
    private boolean hasTesters;
    private boolean hasTechAuthor;
    private int analiticsNeeds;
    private int analiticsHired;
    private int developersNeeds;
    private int developersHired;
    private int testersNeeds;
    private int testersHired;
    private int techAuthorsNeeds;
    private int techAuthorsHired;

}

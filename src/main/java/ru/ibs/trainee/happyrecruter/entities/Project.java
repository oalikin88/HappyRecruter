package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table

public class Project {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private IbsStaff ibsStaff;
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

package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberTeam {
    @Id
    @GeneratedValue
    private Long id;


    private float countNeeds;
    private float countHired;
    private LocalDate dateStartProject;

    @ManyToOne
    @JoinColumn(name = "ID_staff")
    private StaffList staffList;



    public MemberTeam(Long id, float countNeeds, float countHired, LocalDate dateStartProject) {
        this.id = id;
        this.countNeeds = countNeeds;
        this.countHired = countHired;
        this.dateStartProject = dateStartProject;
    }


}

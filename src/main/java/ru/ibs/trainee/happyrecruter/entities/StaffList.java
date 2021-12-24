package ru.ibs.trainee.happyrecruter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
public class StaffList {

    @Id
    @GeneratedValue
    private Long id;
    private String staffName;
    
	public StaffList(String staffName) {
		this.staffName = staffName;
	}

    
    
}

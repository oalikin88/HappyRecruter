package ru.ibs.trainee.happyrecruter.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Data
@Component
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


	public MemberTeam(float countNeeds, float countHired, LocalDate dateStartProject) {
		this.countNeeds = countNeeds;
		this.countHired = countHired;
		this.dateStartProject = dateStartProject;
		
	}
        

        
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberTeam other = (MemberTeam) obj;
		return Float.floatToIntBits(countHired) == Float.floatToIntBits(other.countHired)
				&& Float.floatToIntBits(countNeeds) == Float.floatToIntBits(other.countNeeds)
				&& Objects.equals(dateStartProject, other.dateStartProject) && Objects.equals(id, other.id)
				&& Objects.equals(staffList, other.staffList);
	}



	@Override
	public int hashCode() {
		return Objects.hash(countHired, countNeeds, dateStartProject, id, staffList);
	}


}

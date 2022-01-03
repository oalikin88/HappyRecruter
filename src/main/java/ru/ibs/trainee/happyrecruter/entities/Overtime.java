package ru.ibs.trainee.happyrecruter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Overtime {

    @Id
    @GeneratedValue
    private Long id;
    private String overtimeName;
    
	public Overtime(String overtimeName) {
		this.overtimeName = overtimeName;
	}
    
	
	
	public Overtime() {
		super();
	}
	
	



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getOvertimeName() {
		return overtimeName;
	}



	public void setOvertimeName(String overtimeName) {
		this.overtimeName = overtimeName;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Overtime other = (Overtime) obj;
		return Objects.equals(id, other.id) && Objects.equals(overtimeName, other.overtimeName);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, overtimeName);
	}

    
    
}

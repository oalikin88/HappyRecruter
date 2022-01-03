package ru.ibs.trainee.happyrecruter.entities;

import lombok.Data;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stageName;
    
    public Stage(String stageName) {
    	this.stageName = stageName;
    }
    
    public Stage () {
    	
    }
    
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stage other = (Stage) obj;
		return Objects.equals(id, other.id) && Objects.equals(stageName, other.stageName);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, stageName);
	}
    
    
}

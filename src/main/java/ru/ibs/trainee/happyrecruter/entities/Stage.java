package ru.ibs.trainee.happyrecruter.entities;

import lombok.Data;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
public class Stage {

    @Id
    @GeneratedValue
    private Long id;
    private String stageName;
    
    public Stage(String stageName) {
    	this.stageName = stageName;
    }
    
    public Stage () {
    	
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

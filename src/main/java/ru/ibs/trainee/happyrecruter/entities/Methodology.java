package ru.ibs.trainee.happyrecruter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@NoArgsConstructor
@Data
@Component
public class Methodology {

    @Id
    @GeneratedValue
    private Long id;
    private String methodologyName;
    
	public Methodology(String methodologyName) {
		this.methodologyName = methodologyName;
	}
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Methodology other = (Methodology) obj;
		return Objects.equals(id, other.id) && Objects.equals(methodologyName, other.methodologyName);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, methodologyName);
	}

    
    
}

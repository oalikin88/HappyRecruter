package ru.ibs.trainee.happyrecruter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@NoArgsConstructor
@Component
public class Type2 {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "type_value")
    private String type;
    
	public Type2(String type) {
		this.type = type;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type2 other = (Type2) obj;
		return Objects.equals(id, other.id) && Objects.equals(type, other.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


}


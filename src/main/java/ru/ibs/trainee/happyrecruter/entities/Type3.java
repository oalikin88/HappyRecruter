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
@Data
@NoArgsConstructor
@Component
public class Type3 {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "type_value")
    private String type;
    
	public Type3(String type) {
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
		Type3 other = (Type3) obj;
		return Objects.equals(id, other.id) && Objects.equals(type, other.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}



}


package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Type4 {

    @Id
    @GeneratedValue
    private Long Id;
    @Column(name = "type_value")
    private String type;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type4 other = (Type4) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(type, other.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, type);
	}
}


package ru.ibs.trainee.happyrecruter.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectStatus {

    @Id
    @GeneratedValue
    private Long id;
    private String statusValue;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectStatus other = (ProjectStatus) obj;
		return Objects.equals(id, other.id) && Objects.equals(statusValue, other.statusValue);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, statusValue);
	}
	@Override
	public String toString() {
		return "ProjectStatus [id=" + id + ", statusValue=" + statusValue + ", hashCode()=" + hashCode() + ", getId()="
				+ getId() + ", getStatusValue()=" + getStatusValue() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}



}

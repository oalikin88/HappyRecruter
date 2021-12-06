package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Overtime;

public interface OvertimeRepository extends CrudRepository<Overtime, Long> {
    Overtime findByOvertimeNameIs(String overtime);
}

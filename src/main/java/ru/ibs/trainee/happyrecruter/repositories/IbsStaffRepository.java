package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.IbsStaff;

public interface IbsStaffRepository  extends CrudRepository<IbsStaff, Long> {
}

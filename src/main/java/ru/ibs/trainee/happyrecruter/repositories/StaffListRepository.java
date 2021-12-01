package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.StaffList;

public interface StaffListRepository extends CrudRepository<StaffList, Long> {
    public StaffList findStaffListByStaffNameIs(String staffName);
}

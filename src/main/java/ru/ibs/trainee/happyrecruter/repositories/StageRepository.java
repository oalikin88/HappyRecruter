package ru.ibs.trainee.happyrecruter.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.trainee.happyrecruter.entities.Stage;

public interface StageRepository extends CrudRepository<Stage, Long> {
    public Stage findByStageNameIs(String stage);
}

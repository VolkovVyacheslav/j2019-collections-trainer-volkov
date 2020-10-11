package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.AchievementsEntity;

import java.util.List;

public interface AchievementsRepository {
    List<AchievementsEntity> findAll();
    AchievementsEntity findById (Long id);
    AchievementsEntity create (AchievementsEntity achievement);
    AchievementsEntity update (AchievementsEntity achievement);
    void deleteById (Long id);
    void deleteAll();
}

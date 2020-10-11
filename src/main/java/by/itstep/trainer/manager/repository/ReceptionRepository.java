package by.itstep.trainer.manager.repository;


import by.itstep.trainer.manager.entity.ReceptionEntity;

import java.util.List;

public interface ReceptionRepository {
    List<ReceptionEntity> findAll();
    ReceptionEntity findById (Long id);
    ReceptionEntity create (ReceptionEntity reception);
    ReceptionEntity update (ReceptionEntity reception);
    void deleteById (Long id);
    void deleteAll();
}

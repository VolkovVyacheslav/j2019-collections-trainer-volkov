package by.itstep.trainer.manager.repository;


import by.itstep.trainer.manager.entity.SpecializationsEntity;

import java.util.List;

public interface SpecializationsRepository {
    List<SpecializationsEntity> findAll();
    SpecializationsEntity findById (Long id);
    SpecializationsEntity create (SpecializationsEntity specialization);
    SpecializationsEntity update (SpecializationsEntity specialization);
    void deleteById (Long id);
    void deleteAll();
}

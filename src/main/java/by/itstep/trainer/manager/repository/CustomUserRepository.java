package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.CustomUserEntity;


import java.util.List;

public interface CustomUserRepository {
    List<CustomUserEntity> findAll();
    CustomUserEntity findById (Long id);
    CustomUserEntity create (CustomUserEntity user);
    CustomUserEntity update (CustomUserEntity user);
    void deleteById (Long id);
    void deleteAll();
}

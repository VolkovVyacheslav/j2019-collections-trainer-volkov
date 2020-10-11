package by.itstep.trainer.manager.repository;


import by.itstep.trainer.manager.entity.AdminUserEntity;


import java.util.List;

public interface AdminUserRepository {
    List<AdminUserEntity> findAll();
    AdminUserEntity findById (Long id);
    AdminUserEntity create (AdminUserEntity admin);
    AdminUserEntity update (AdminUserEntity admin);
    void deleteById (Long id);
    void deleteAll();
}

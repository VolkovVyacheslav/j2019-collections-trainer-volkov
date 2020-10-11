package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.InstructorEntity;

import java.util.List;

public interface InstructorRepository {
    List<InstructorEntity> findAll();
    InstructorEntity findById (Long id);
    InstructorEntity create (InstructorEntity instructor);
    InstructorEntity update (InstructorEntity instructor);
    void deleteById (Long id);
    void deleteAll();

}

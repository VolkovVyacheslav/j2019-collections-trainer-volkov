package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.CommentsEntity;


import java.util.List;

public interface CommentsRepository {
    List<CommentsEntity> findAll();
    CommentsEntity findById (Long id);
    CommentsEntity create (CommentsEntity comment);
    CommentsEntity update (CommentsEntity comment);
    void deleteById (Long id);
    void deleteAll();
}

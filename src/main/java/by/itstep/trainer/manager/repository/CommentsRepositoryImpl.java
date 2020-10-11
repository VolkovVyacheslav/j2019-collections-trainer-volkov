package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.CommentsEntity;
import by.itstep.trainer.manager.util.EntityManagerUtils;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.util.List;

public class CommentsRepositoryImpl implements CommentsRepository{
    @Override
    public List<CommentsEntity> findAll() {
        EntityManager em = EntityManagerUtils.getEntityManger();
        List<CommentsEntity> foundList = em.createNativeQuery("SELECT * FROM comments",
                CommentsEntity.class).getResultList();
        em.close();
        return foundList;
    }

    @Override
    public CommentsEntity findById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        CommentsEntity foundComment = em.find(CommentsEntity.class, id);
        Hibernate.initialize(foundComment.getCustomUser());
        Hibernate.initialize(foundComment.getInstructor());
        em.close();
        return foundComment;
    }

    @Override
    public CommentsEntity create(CommentsEntity comment) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.persist(comment);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return comment;
    }

    @Override
    public CommentsEntity update(CommentsEntity comment) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.merge(comment);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return comment;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            CommentsEntity foundComment = em.find(CommentsEntity.class, id);
            em.merge(foundComment);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void deleteAll() {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try {
            em.getTransaction().begin();
            em.createNativeQuery("DELETE  FROM comments").executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}

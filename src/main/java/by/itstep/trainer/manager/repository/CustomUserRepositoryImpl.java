package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.CustomUserEntity;
import by.itstep.trainer.manager.util.EntityManagerUtils;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository{
    @Override
    public List<CustomUserEntity> findAll() {
        EntityManager em = EntityManagerUtils.getEntityManger();
        List<CustomUserEntity> foundList = em.createNativeQuery("SELECT * FROM custom_usrs",
                CustomUserEntity.class).getResultList();
        em.close();
        return foundList;
    }

    @Override
    public CustomUserEntity findById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        CustomUserEntity foundUser = em.find(CustomUserEntity.class, id);
        Hibernate.initialize(foundUser.getCommentsList());
        Hibernate.initialize(foundUser.getReceptionList());
        em.close();
        return foundUser;
    }

    @Override
    public CustomUserEntity create(CustomUserEntity user) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return user;
    }

    @Override
    public CustomUserEntity update(CustomUserEntity user) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return user;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            CustomUserEntity foundUser = em.find(CustomUserEntity.class, id);
            em.merge(foundUser);
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
            em.createNativeQuery("DELETE  FROM custom_usrs").executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}

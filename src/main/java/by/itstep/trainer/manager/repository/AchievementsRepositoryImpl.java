package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.AchievementsEntity;
import by.itstep.trainer.manager.util.EntityManagerUtils;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.util.List;

public class AchievementsRepositoryImpl implements AchievementsRepository{
    @Override
    public List<AchievementsEntity> findAll() {
        EntityManager em = EntityManagerUtils.getEntityManger();
        List<AchievementsEntity> foundList = em.createNativeQuery("SELECT * FROM achievements",
                AchievementsEntity.class).getResultList();
        em.close();
        return foundList;
    }

    @Override
    public AchievementsEntity findById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        AchievementsEntity foundAchievement = em.find(AchievementsEntity.class, id);
        Hibernate.initialize(foundAchievement.getInstructor());
        em.close();
        return foundAchievement;
    }

    @Override
    public AchievementsEntity create(AchievementsEntity achievement) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.persist(achievement);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return achievement;
    }

    @Override
    public AchievementsEntity update(AchievementsEntity achievement) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.merge(achievement);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return achievement;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            AchievementsEntity foundAchievement = em.find(AchievementsEntity.class, id);
            em.remove(foundAchievement);
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
            em.createNativeQuery("DELETE  FROM achievements").executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}

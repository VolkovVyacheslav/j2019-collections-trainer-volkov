package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.ReceptionEntity;
import by.itstep.trainer.manager.util.EntityManagerUtils;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.util.List;

public class ReceptionRepositoryImpl implements ReceptionRepository{
    @Override
    public List<ReceptionEntity> findAll() {
        EntityManager em = EntityManagerUtils.getEntityManger();
        List<ReceptionEntity> foundList = em.createNativeQuery("SELECT * FROM receptions",
                ReceptionEntity.class).getResultList();
        em.close();
        return foundList;
    }

    @Override
    public ReceptionEntity findById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        ReceptionEntity foundReceptoin = em.find(ReceptionEntity.class, id);
        Hibernate.initialize(foundReceptoin.getInstructor());
        Hibernate.initialize(foundReceptoin.getUser());
        em.close();
        return foundReceptoin;
    }

    @Override
    public ReceptionEntity create(ReceptionEntity reception) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.persist(reception);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return reception;
    }

    @Override
    public ReceptionEntity update(ReceptionEntity reception) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.merge(reception);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return reception;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            ReceptionEntity foundReception = em.find(ReceptionEntity.class, id);
            em.persist(foundReception);
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
            em.createNativeQuery("DELETE  FROM receptions").executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}

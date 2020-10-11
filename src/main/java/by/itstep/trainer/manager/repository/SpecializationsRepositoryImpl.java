package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.SpecializationsEntity;
import by.itstep.trainer.manager.util.EntityManagerUtils;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.util.List;

public class SpecializationsRepositoryImpl implements SpecializationsRepository{
    @Override
    public List<SpecializationsEntity> findAll() {
        EntityManager em = EntityManagerUtils.getEntityManger();
        List<SpecializationsEntity> foundList = em.createNativeQuery("SELECT * FROM specializations",
                SpecializationsEntity.class).getResultList();
        em.close();
        return foundList;
    }

    @Override
    public SpecializationsEntity findById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        SpecializationsEntity foundSpecialization = em.find(SpecializationsEntity.class, id);
        Hibernate.initialize(foundSpecialization.getInstructor());
        em.close();
        return foundSpecialization;
    }

    @Override
    public SpecializationsEntity create(SpecializationsEntity specialization) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.persist(specialization);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return specialization;
    }

    @Override
    public SpecializationsEntity update(SpecializationsEntity specialization) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.merge(specialization);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return specialization;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            SpecializationsEntity foundSpecialization = em.find(SpecializationsEntity.class, id);
            em.merge(foundSpecialization);
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
            em.createNativeQuery("DELETE  FROM specializations").executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}

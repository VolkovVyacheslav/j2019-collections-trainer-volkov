package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.InstructorEntity;
import by.itstep.trainer.manager.util.EntityManagerUtils;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository{
    @Override
    public List<InstructorEntity> findAll() {
        EntityManager em = EntityManagerUtils.getEntityManger();
        List<InstructorEntity> foundList = em.createNativeQuery("SELECT * FROM instructor",
                InstructorEntity.class).getResultList();
        for (InstructorEntity instructor:
            foundList ) {
            Hibernate.initialize(instructor.getSpecializationsList());
        }
        em.close();
        return foundList;
    }

    @Override
    public InstructorEntity findById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        InstructorEntity foundInstructor = em.find(InstructorEntity.class, id);
      //  Hibernate.initialize(foundInstructor.getAchievementsList());
        Hibernate.initialize(foundInstructor.getCommentsList());
        Hibernate.initialize(foundInstructor.getReceptionList());
        Hibernate.initialize(foundInstructor.getSpecializationsList());
        em.close();
        return foundInstructor;
    }

    @Override
    public InstructorEntity create(InstructorEntity instructor) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.persist(instructor);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return instructor;
    }

    @Override
    public InstructorEntity update(InstructorEntity instructor) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.merge(instructor);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return instructor;
    }

    @Override
    public void deleteById(Long id) {
       EntityManager em = EntityManagerUtils.getEntityManger();
       try{
           em.getTransaction().begin();
           InstructorEntity foundInstructor = em.find(InstructorEntity.class, id);
           em.remove(foundInstructor);
           em.getTransaction().commit();
       }catch (Exception e){
           em.getTransaction().rollback();

       }finally {
           em.close();
       }
    }

    @Override
    public void deleteAll() {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try {
            em.getTransaction().begin();
            em.createNativeQuery("DELETE  FROM instructor").executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}

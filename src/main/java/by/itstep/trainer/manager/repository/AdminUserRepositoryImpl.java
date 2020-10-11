package by.itstep.trainer.manager.repository;

import by.itstep.trainer.manager.entity.AdminUserEntity;
import by.itstep.trainer.manager.util.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AdminUserRepositoryImpl implements AdminUserRepository{
    @Override
    public List<AdminUserEntity> findAll() {
        EntityManager em= EntityManagerUtils.getEntityManger();
        List<AdminUserEntity> foundList = em.createNativeQuery("SELECT * FROM admins",
                AdminUserEntity.class).getResultList();
        em.close();
        return foundList;
    }

    @Override
    public AdminUserEntity findById(Long id) {
        EntityManager em= EntityManagerUtils.getEntityManger();
        AdminUserEntity foundAdmin = em.find(AdminUserEntity.class, id);
        em.close();
        return foundAdmin;
    }

    @Override
    public AdminUserEntity create(AdminUserEntity admin) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return admin;
    }

    @Override
    public AdminUserEntity update(AdminUserEntity admin) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            em.merge(admin);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return admin;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManger();
        try{
            em.getTransaction().begin();
            AdminUserEntity foundAdmin = em.find(AdminUserEntity.class, id);
            em.remove(foundAdmin);
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
            em.createNativeQuery("DELETE  FROM admins").executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}

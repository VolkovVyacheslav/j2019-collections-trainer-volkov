package by.itstep.trainer.manager.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("instructors-unit");

    public static EntityManager getEntityManger(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
    
}

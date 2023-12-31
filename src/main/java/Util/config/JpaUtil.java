package Util.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static EntityManager em;

    private JpaUtil() {

    }

    public static EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory("football").createEntityManager();
        }
        return em;
    }
}

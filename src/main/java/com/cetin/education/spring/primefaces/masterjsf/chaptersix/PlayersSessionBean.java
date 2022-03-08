package com.cetin.education.spring.primefaces.masterjsf.chaptersix;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-31
 */
public class PlayersSessionBean {
    private EntityManager em;

    /*Finally, round off by applying the filter criteria using SQL queries as follows:*/
    public Set<Players> loadPlayersAction(int first, int max, String criteria) {
        if (criteria.equals("all")) {
            Query query = em.createNamedQuery("Players.findAll");
            query.setFirstResult(first);
            query.setMaxResults(max);
            return new HashSet(query.getResultList());
        }
        if (criteria.equals("<26")) {
            Query query = em.createQuery("SELECT p FROM Players p WHERE p.age < 26");
            query.setFirstResult(first);
            query.setMaxResults(max);
            return new HashSet(query.getResultList());
        }
        if (criteria.equals(">=26")) {
            Query query = em.createQuery("SELECT p FROM Players p WHERE p.age >= 26");
            query.setFirstResult(first);
            query.setMaxResults(max);
            return new HashSet(query.getResultList());
        }
        return null;
    }

    /*Count the number of rows returned by the filter as follows:*/
    public int countPlayersAction(String criteria) {
        if (criteria.equals("all")) {
            Query query = em.createNamedQuery("Players.countAll");
            return ((Long) query.getSingleResult()).intValue();
        }
        if (criteria.equals("<26")) {
            Query query = em.createQuery("SELECT COUNT(p) FROM Players p WHERE p.age < 26");
            return ((Long) query.getSingleResult()).intValue();
        }
        if (criteria.equals(">=26")) {
            Query query = em.createQuery("SELECT COUNT(p) FROM Players p WHERE p.age >= 26");
            return ((Long) query.getSingleResult()).intValue();
        }
        return 0;
    }
}

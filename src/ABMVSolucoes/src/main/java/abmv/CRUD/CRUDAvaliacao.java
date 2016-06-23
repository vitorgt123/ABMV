/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.CRUD;

import abmv.Entidade.Avaliacao;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcelo
 */
public class CRUDAvaliacao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("abmv_ABMVSolucoes_war_1.0-SNAPSHOTPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Collection<Avaliacao> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Avaliacao.findAll").getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            return null;
        } finally {
            em.close();
        }
    }

    public void remove(Avaliacao avaliacao) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Avaliacao d;
            d = em.find(Avaliacao.class, avaliacao.getAvaliacaoPK());
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Avaliacao avaliacao) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Avaliacao d;
            d = em.find(Avaliacao.class, avaliacao.getAvaliacaoPK());
            d.setPeso(avaliacao.getPeso());
            d.setNota(avaliacao.getNota());
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

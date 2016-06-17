/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.CRUD;

import abmv.Entidade.Disciplina;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcelo
 */
public class CRUDDisciplina {

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

    public java.util.Collection<Disciplina> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Disciplina.findAll").getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            return null;
        } finally {
            em.close();
        }
    }

    public void remove(Disciplina disciplina) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Disciplina d;
            d = em.find(Disciplina.class, disciplina.getId());
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Disciplina disciplina) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Disciplina d;
            d = em.find(Disciplina.class, disciplina.getId());
            d.setNome(disciplina.getNome());        
            d.setCurso(disciplina.getCurso());
            d.setProfessor(disciplina.getProfessor());
            d.setQtdeaulas(disciplina.getQtdeaulas());                          
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.CRUD;

import abmv.Entidade.Conteudo;
import abmv.Entidade.Matricula;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class CRUDConteudo {

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

    public Collection<Conteudo> getContByDisc(int id){
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT * FROM conteudo WHERE disciplina="+id, Conteudo.class);
            return  (Collection<Conteudo>) query.getResultList();
            //return em.createQuery("SELECT * FROM matricula WHERE disciplina="+id,Matricula.class).getResultList();
//            return em.createNamedQuery("Matricula.findMatriculaByDisciplina").getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            return null;
        } finally {
            em.close();
        }
    }
    
    public Collection<Conteudo> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Conteudo.findAll").getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            return null;
        } finally {
            em.close();
        }
    }

    public void remove(Conteudo conteudo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Conteudo d;
            d = em.find(Conteudo.class, conteudo.getConteudoPK());
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Conteudo conteudo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Conteudo d;
            d = em.find(Conteudo.class, conteudo.getConteudoPK());
            d.setDescricao(conteudo.getDescricao());
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

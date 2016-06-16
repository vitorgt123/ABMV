/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.CRUD;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vitor
 */
public class CRUDAluno {

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

    public java.util.Collection<abmv.Entidades.Aluno> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Aluno.findAll").getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            return null;
        } finally {
            em.close();
        }
    }

    public void remove(abmv.Entidades.Aluno pessoa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            abmv.Entidades.Aluno p;
            p = em.find(abmv.Entidades.Aluno.class, pessoa.getId());
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(abmv.Entidades.Aluno pessoa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            abmv.Entidades.Aluno p;
            p = em.find(abmv.Entidades.Aluno.class, pessoa.getId());
            p.setNome(pessoa.getNome());
            p.setEmail(pessoa.getEmail());
            p.setCurso(pessoa.getCurso());
            p.setPeriodo(pessoa.getPeriodo());
            p.setNascimento(pessoa.getNascimento());
            p.setCidade(pessoa.getCidade());
            p.setEstado(pessoa.getEstado());
            p.setDoc(pessoa.getDoc());            
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}

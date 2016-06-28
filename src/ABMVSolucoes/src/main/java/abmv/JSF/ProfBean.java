/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.CRUD.CRUDProfessor;
import abmv.Entidade.Professor;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author X
 */
@ManagedBean
@RequestScoped
public class ProfBean {

    private static int id;
    private String nome;
    private String email;
    private String titulo;
    private static int lastid;
    /**
     * Creates a new instance of ProfBean
     */
    public ProfBean() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ProfBean.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Collection<Professor> getAll() {
        List<Professor> array = (List<Professor>) new CRUDProfessor().getAll();
        lastid = 1;
        if (!array.isEmpty()) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).getId() > lastid) {
                    lastid = array.get(i).getId();
                }
            }
            lastid++;
        }
        return array;
    }
    
    public void remove(Professor professor) {
        new abmv.CRUD.CRUDProfessor().remove(professor);
    }

    public void salvar() {
        Professor professor;
        professor = new Professor();
        professor.setId(lastid);
        professor.setNome(nome);
        professor.setTitulo(titulo);
        professor.setEmail(email);                    
        new abmv.CRUD.CRUDProfessor().persist(professor);
    }
    
    public void update() {
        Professor professor;
        professor = new Professor();
        professor.setId(id);
        professor.setNome(nome);
        professor.setTitulo(titulo);
        professor.setEmail(email);                
        new abmv.CRUD.CRUDProfessor().update(professor);
    }

    public void load_data(Professor professor) {
        id = professor.getId();
        email = professor.getEmail();
        nome = professor.getNome();
        titulo = professor.getTitulo();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Professor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class JsfProfessor {

    /**
     * Creates a new instance of JsfProfessor
     */
    private int id;
    private String nome;
    private String email;
    private String titulo;
        
    public JsfProfessor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public String goHome(){
        return "home.xhtml";
    }
    
    public void salvar() {
        Professor professor;
        professor = new Professor();
        professor.setId(id);
        professor.setNome(nome);
        professor.setTitulo(titulo);
        professor.setEmail(email);                    
        new abmv.CRUD.CRUDProfessor().persist(professor);
    }

    public java.util.Collection<Professor> getAll() {
        return new abmv.CRUD.CRUDProfessor().getAll();
    }

    public void remove(Professor professor) {
        new abmv.CRUD.CRUDProfessor().remove(professor);
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
        this.id = professor.getId();
        this.email = professor.getEmail();
        this.nome = professor.getNome();
        this.titulo = professor.getTitulo();
    }
    
}

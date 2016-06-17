/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Disciplina;
import abmv.Entidade.Professor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class JsfDisciplina {

    private int id;
    private String nome;
    private String curso;
    private Professor professor;
    private int qtdAulas;

    public JsfDisciplina() {
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getQtdAulas() {
        return qtdAulas;
    }

    public void setQtdAulas(int qtdAulas) {
        this.qtdAulas = qtdAulas;
    }

    public void salvar() {
        Disciplina disciplina;
        disciplina = new Disciplina();
        disciplina.setId(id);
        disciplina.setNome(nome);
        disciplina.setCurso(curso);
        disciplina.setQtdeaulas(qtdAulas);
        System.out.println(professor);
        disciplina.setProfessor(professor);
        new abmv.CRUD.CRUDDisciplina().persist(disciplina);
    }
    
    public void valueChanged(Professor professor){
        this.professor=professor;
        System.out.println("Professor mudado "+professor.getNome());
    }

    public java.util.Collection<Disciplina> getAll() {
        return new abmv.CRUD.CRUDDisciplina().getAll();
    }

    public void remove(Disciplina disciplina) {
        new abmv.CRUD.CRUDDisciplina().remove(disciplina);
    }

    public void update() {
        Disciplina disciplina;
        disciplina = new Disciplina();
        disciplina.setId(id);
        disciplina.setNome(nome);
        disciplina.setCurso(curso);
        disciplina.setQtdeaulas(qtdAulas);
        disciplina.setProfessor(professor);
        new abmv.CRUD.CRUDDisciplina().update(disciplina);
    }

    public void load_data(Disciplina discplina) {
        this.id = discplina.getId();
        this.nome = discplina.getNome();
        this.professor = discplina.getProfessor();
        this.qtdAulas = discplina.getQtdeaulas();
        this.curso = discplina.getCurso();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Aulas;
import abmv.Entidade.AulasPK;
import abmv.Entidade.Matricula;
import abmv.Entidade.Professor;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcelopaglione
 */
@ManagedBean
@SessionScoped
public class JsfPresenca {
    private Aulas aulas;
    private int matricula;
    private String dia;
    private int faltas;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public JsfPresenca() {
    }

    public Aulas getAulas() {
        return aulas;
    }

    public void setAulas(Aulas aulas) {
        this.aulas = aulas;
    }
    
    
    
    public void salvar() {
        Aulas aulas;
        aulas = new Aulas();
        aulas.setAulasPK(new AulasPK(matricula, dia));
        aulas.setFaltas(faltas);
        new abmv.CRUD.CRUDDisciplina().persist(aulas);
    }
    
    /*public void valueChanged(Professor professor){
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
    */
    
}

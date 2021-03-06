/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Aluno;
import abmv.Entidade.Disciplina;
import abmv.Entidade.Matricula;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class JsfMatricula {

    private int id;
    private Disciplina disciplina;
    private Aluno aluno;
    private static Collection<Matricula> matriculas;

    public JsfMatricula(int id, Disciplina disciplina, Aluno aluno) {
        this.id = id;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }
   
    public Collection<Matricula> getMatriculas() {        
        return matriculas;
    }

    public void setMatriculas(Collection<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    

    public JsfMatricula() {
    }

    @Override
    public String toString() {
        return "JsfMatricula{" + "id=" + id + ", disciplina=" + disciplina + ", aluno=" + aluno + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void salvar() {
        Matricula matricula;
        matricula = new Matricula(((List<Matricula>)matriculas).get(matriculas.size()-1).getId()+1);
        matricula.setAluno(aluno);
        matricula.setDisciplina(disciplina);                
        new abmv.CRUD.CRUDMatricula().persist(matricula);
        getMatriculaByDisciplina();
        
    }

//    public void valueChanged(Matricula matricula) {
//        this.professor = professor;
//        System.out.println("Professor mudado " + professor.getNome());
//    }
    

    public java.util.Collection<Matricula> getAll() {
        matriculas = new abmv.CRUD.CRUDMatricula().getAll();
        return matriculas;
    }
    
    public void getMatriculaByDisciplina() {
        matriculas = new abmv.CRUD.CRUDMatricula().getMatriculaByDisciplina(disciplina.getId());
        //return matriculas;
    }

    public void remove(Matricula matricula) {
        new abmv.CRUD.CRUDMatricula().remove(matricula);
    }

    public void update() {
        Matricula matricula;
        matricula = new Matricula(id);
        matricula.setAluno(aluno);
        matricula.setDisciplina(disciplina);
        new abmv.CRUD.CRUDMatricula().update(matricula);
    }

    public void load_data(Matricula matricula) {
        this.id = matricula.getId();
        this.disciplina = matricula.getDisciplina();
        this.aluno = matricula.getAluno();
    }

}

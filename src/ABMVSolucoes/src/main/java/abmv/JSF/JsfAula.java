/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Aulas;
import abmv.Entidade.Matricula;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class JsfAula {
    private Matricula matriculaId;
    private String dia;
    private int faltas;

    @Override
    public String toString() {
        return "JsfAula{" + "matriculaId=" + matriculaId + ", dia=" + dia + ", faltas=" + faltas + '}';
    }

    public JsfAula(Matricula matriculaId, String dia, int faltas) {
        this.matriculaId = matriculaId;
        this.dia = dia;
        this.faltas = faltas;
    }

    public JsfAula() {
    }

    public Matricula getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Matricula matriculaId) {
        this.matriculaId = matriculaId;
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
    
     public void salvar() {
        Aulas aula;
        aula = new Aulas(matriculaId.getId(),dia);
        aula.setFaltas(faltas);        
        new abmv.CRUD.CRUDAula().persist(aula);
    }
    
//    public void valueChanged(Aulas aulas){
//        this.professor=professor;
//        System.out.println("Professor mudado "+professor.getNome());
//    }

    public Collection<Aulas> getAll() {
        return new abmv.CRUD.CRUDAula().getAll();
    }

    public void remove(Aulas aulas) {
        new abmv.CRUD.CRUDAula().remove(aulas);
    }

    public void update() {                
        Aulas aula;
        aula = new Aulas(matriculaId.getId(),dia);
        aula.setFaltas(faltas);    
        new abmv.CRUD.CRUDAula().update(aula);
    }

    public void load_data(Aulas aula) {
        this.dia = aula.getAulasPK().getDia();
        this.faltas = aula.getFaltas();
        this.matriculaId = aula.getMatricula1();        
    }
    
}

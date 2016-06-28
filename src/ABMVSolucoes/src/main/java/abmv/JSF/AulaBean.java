/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.CRUD.CRUDAula;
import abmv.CRUD.CRUDConteudo;
import abmv.CRUD.CRUDDisciplina;
import abmv.CRUD.CRUDMatricula;
import abmv.Entidade.Aulas;
import abmv.Entidade.AulasPK;
import abmv.Entidade.Conteudo;
import abmv.Entidade.ConteudoPK;
import abmv.Entidade.Disciplina;
import abmv.Entidade.Matricula;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author X
 */
@ManagedBean
@RequestScoped
public class AulaBean {

    private Disciplina disciplina;
    private String dia;
    private String descricao;
    private int qtda;
    private static List<Matricula> matrs;
    private static List<Aulas> aulas;
    /**
     * Creates a new instance of AulaBean
     */
    public AulaBean() {
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtda() {
        return qtda;
    }

    public void setQtda(int qtda) {
        this.qtda = qtda;
    }

    public List<Matricula> getMatrs() {
        return matrs;
    }

    public void setMatrs(List<Matricula> matrs) {
        AulaBean.matrs = matrs;
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        AulaBean.aulas = aulas;
    }
    
    public void refreshAlunos(){
        aulas = new ArrayList();
        matrs = (List<Matricula>) new CRUDMatricula().getMatriculaByDisciplina(disciplina.getId());
        for(Matricula mat : matrs){
            Aulas aula = new Aulas(new AulasPK(mat.getId(),dia),0);
            aula.setMatricula1(mat);
            aulas.add(aula);
        }
    }
    
    public void salvar(){
        disciplina.setQtdeaulas(disciplina.getQtdeaulas() + qtda);
        Conteudo cont = new Conteudo();
        cont.setConteudoPK(new ConteudoPK(disciplina.getId(), dia));
        cont.setDisciplina1(disciplina);
        cont.setDescricao(descricao);
        new CRUDConteudo().persist(cont);
        new CRUDDisciplina().update(disciplina);
    }
    
    public void insertFaltas(Aulas aula){
        new CRUDAula().persist(aula);
    }
    
}

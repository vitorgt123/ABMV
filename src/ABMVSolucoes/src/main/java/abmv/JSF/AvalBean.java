/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.CRUD.CRUDMatricula;
import abmv.Entidade.Avaliacao;
import abmv.Entidade.Disciplina;
import abmv.Entidade.Matricula;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Bianca
 */
@ManagedBean
@RequestScoped
public class AvalBean {

    private int val;
    private String nome;
    private static List<Matricula> matrs;
    private static List<Avaliacao> avals;
    private Disciplina disciplina;
    /**
     * Creates a new instance of AvalBean
     */
    public AvalBean() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Matricula> getMatrs() {
        return matrs;
    }

    public void setMatrs(List<Matricula> matrs) {
        AvalBean.matrs = matrs;
    }

    public List<Avaliacao> getAvals() {
        return avals;
    }

    public void setAvals(List<Avaliacao> avals) {
        AvalBean.avals = avals;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public void refreshAlunos(){
        //aulas = new ArrayList();
        matrs = (List<Matricula>) new CRUDMatricula().getMatriculaByDisciplina(disciplina.getId());
//        for(Matricula mat : matrs){
//            Aulas aula = new Aulas(new AulasPK(mat.getId(),dia),0);
//            aula.setMatricula1(mat);
//            aulas.add(aula);
//        }
    }
    
}

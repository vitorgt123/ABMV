/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.CRUD.CRUDAula;
import abmv.CRUD.CRUDConteudo;
import abmv.CRUD.CRUDMatricula;
import abmv.Entidade.Aluno;
import abmv.Entidade.Aulas;
import abmv.Entidade.Conteudo;
import abmv.Entidade.Matricula;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.junit.Test;

/**
 *
 * @author marcelopaglione
 */
@ManagedBean
@RequestScoped
public class ViewFBean {

    private Aluno aluno;
    private Matricula matr;
    private static List<Matricula> matrs;
    private static List<Aulas> aulas;
    private static List<Conteudo> cont;
    private static int total;
    private static int faltas;
    private static float pocentagem;

    /**
     * Creates a new instance of ViewFBean
     */
    public ViewFBean() {
    }

    public float getPocentagem() {
        return pocentagem;
    }

    public void setPocentagem(float pocentagem) {
        ViewFBean.pocentagem = pocentagem;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Matricula getMatr() {
        return matr;
    }

    public void setMatr(Matricula matr) {
        this.matr = matr;
    }

    public List<Matricula> getMatrs() {
        return matrs;
    }

    public void setMatrs(List<Matricula> matrs) {
        ViewFBean.matrs = matrs;
    }

    public void refreshMatr() {
        matrs = (List<Matricula>) new CRUDMatricula().getMatrByAluno(aluno.getId());
    }

    public void refreshAulas() {
        aulas = (List<Aulas>) new CRUDAula().getAulaByMtr(matr.getId());
        cont = (List<Conteudo>) new CRUDConteudo().getContByDisc(matr.getDisciplina().getId());
        total = matr.getDisciplina().getQtdeaulas();
        calc();
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        ViewFBean.aulas = aulas;
    }

    public void calc() {
        faltas = 0;
        for (int i = 0; i < aulas.size(); i++) {
            faltas += aulas.get(i).getFaltas();
        }

        pocentagem = 100 - (faltas / total * 100);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        ViewFBean.total = total;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        ViewFBean.faltas = faltas;
    }

    public List<Conteudo> getCont() {
        return cont;
    }

    public void setCont(List<Conteudo> cont) {
        ViewFBean.cont = cont;
    }
    
}

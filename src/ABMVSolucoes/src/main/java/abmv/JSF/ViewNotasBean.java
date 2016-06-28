/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.CRUD.CRUDAula;
import abmv.CRUD.CRUDMatricula;
import abmv.Entidade.Aluno;
import abmv.Entidade.Aulas;
import abmv.Entidade.Avaliacao;
import abmv.Entidade.Matricula;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author marcelopaglione
 */
@ManagedBean
@RequestScoped
public class ViewNotasBean {

    private Aluno aluno;
    private Matricula matr;
    private Avaliacao av;
    private static List<Matricula> matrs;
    private static List<Aulas> aulas;
    private static List<Avaliacao> avaliacao;
    private static int notas;
    private static int notatotal;
    private static int n1;
    private static int p1;
    private static int total;
    private static int reajuste;

    /**
     * Creates a new instance of ViewFBean
     */
    public ViewNotasBean() {
    }

    public int getReajuste() {
        return reajuste;
    }

    public void setReajuste(int reajuste) {
        ViewNotasBean.reajuste = reajuste;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        ViewNotasBean.n1 = n1;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        ViewNotasBean.p1 = p1;
    }

    public int getNotatotal() {
        return notatotal;
    }

    public void setNotatotal(int notatotal) {
        ViewNotasBean.notatotal = notatotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        ViewNotasBean.total = total;
    }

    public List<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Avaliacao> avaliacao) {
        ViewNotasBean.avaliacao = avaliacao;
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
        ViewNotasBean.matrs = matrs;
    }

    public void refreshMatr() {
        matrs = (List<Matricula>) new CRUDMatricula().getMatrByAluno(aluno.getId());
    }

    public void refreshNotas() {
        avaliacao = (List<Avaliacao>) new CRUDAula().getNotasByMatr(matr.getId());
        CalcMedia();
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        ViewNotasBean.aulas = aulas;
    }

    public Avaliacao getAv() {
        return av;
    }

    public void setAv(Avaliacao av) {
        this.av = av;
    }

    public int getNotas() {
        return notas;
    }

    public void setNotas(int notas) {
        ViewNotasBean.notas = notas;
    }

    public void CalcMedia() {
        notatotal = 0;
        total = 0;

        for (int i = 0; i < avaliacao.size(); i++) {
            n1 = avaliacao.get(i).getNota();
            p1 = avaliacao.get(i).getPeso();
            notatotal = notatotal + n1;
            total = total + p1;                        
        }
        
        Ajuste();
    }
    
    public void Ajuste(){
        reajuste = (notatotal*10) / total;
    }

}

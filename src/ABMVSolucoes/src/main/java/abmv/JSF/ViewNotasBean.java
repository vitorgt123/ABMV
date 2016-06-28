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
import abmv.Entidade.Disciplina;
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
    private Disciplina disc;
    private static List<Matricula> matrs;
    private static List<Aulas> aulas;
    private static int total;
    private static int faltas;
    private static float pocentagem;

    public ViewNotasBean(){
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

    public Disciplina getDisc() {
        return disc;
    }

    public void setDisc(Disciplina disc) {
        this.disc = disc;
    }

    public static List<Matricula> getMatrs() {
        return matrs;
    }

    public static void setMatrs(List<Matricula> matrs) {
        ViewNotasBean.matrs = matrs;
    }

    public static List<Aulas> getAulas() {
        return aulas;
    }

    public static void setAulas(List<Aulas> aulas) {
        ViewNotasBean.aulas = aulas;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        ViewNotasBean.total = total;
    }

    public static int getFaltas() {
        return faltas;
    }

    public static void setFaltas(int faltas) {
        ViewNotasBean.faltas = faltas;
    }

    public void refreshMatr() {
        matrs = (List<Matricula>) new CRUDMatricula().getMatrByAluno(aluno.getId());
    }

    public void refreshAulas() {
        aulas = (List<Aulas>) new CRUDAula().getAulaByMtr(matr.getId());
        total = matr.getDisciplina().getQtdeaulas();
        calc();
    }
    
    public void calc() {
        faltas = 0;
        for (int i = 0; i < aulas.size(); i++) {
            faltas += aulas.get(i).getFaltas();
        }

        pocentagem = 100 - (faltas / total * 100);
    }
    
    public static float getPocentagem() {
        return pocentagem;
    }

    public static void setPocentagem(float pocentagem) {
        ViewNotasBean.pocentagem = pocentagem;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.CRUD.CRUDAluno;
import abmv.CRUD.CRUDMatricula;
import abmv.Entidade.Aluno;
import abmv.Entidade.Disciplina;
import abmv.Entidade.Matricula;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author X
 */
@ManagedBean
@RequestScoped
public class MatrBean {

    private Disciplina disciplina;
    private Aluno aluno;
    private static List<Aluno> addeda;
    private static List<Matricula> matrs;
    private static int lastid;
    private static Disciplina last;

    /**
     * Creates a new instance of MatrBean
     */
    public MatrBean() {
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

    public List<Matricula> getMatrs() {
        return matrs;
    }

    public void setMatrs(List<Matricula> matrs) {
        MatrBean.matrs = matrs;
    }

    public List<Aluno> getAddeda() {
        return addeda;
    }

    public void setAddeda(List<Aluno> addeda) {
        MatrBean.addeda = addeda;
    }

    public static int getLastid() {
        return lastid;
    }

    public static void setLastid(int lastid) {
        MatrBean.lastid = lastid;
    }

    public void refreshMatr() {
        refreshId();
        refreshArray();
        refreshAlunos();
    }

    private void refreshArray() {
        matrs = (List<Matricula>) new CRUDMatricula().getMatriculaByDisciplina(disciplina.getId());
    }

    private void refreshArrayDelete() {
        matrs = (List<Matricula>) new CRUDMatricula().getMatriculaByDisciplina(last.getId());
    }
    
    private void refreshId(){
        List<Matricula> array = (List<Matricula>) new CRUDMatricula().getAll();
        lastid = 1;
        if (!array.isEmpty()) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).getId() > lastid) {
                    lastid = array.get(i).getId();
                }
            }
            lastid++;
        }
    }
    
    private void refreshAlunos() {
        addeda = (List<Aluno>) new CRUDAluno().getAll();
        for (int i = 0; i < matrs.size(); i++) {
            addeda.remove(matrs.get(i).getAluno());
        }
    }

    public void salvar() {
        Matricula matricula;
        matricula = new Matricula(lastid);
        matricula.setAluno(aluno);
        matricula.setDisciplina(disciplina);
        last = disciplina;
        new abmv.CRUD.CRUDMatricula().persist(matricula);
        refreshMatr();
    }

    public void remove(Matricula matricula) {
        new abmv.CRUD.CRUDMatricula().remove(matricula);
        refreshId();
        refreshArrayDelete();
        refreshAlunos();
    }

}

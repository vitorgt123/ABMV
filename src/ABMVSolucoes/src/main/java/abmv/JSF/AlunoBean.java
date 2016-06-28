/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.CRUD.CRUDAluno;
import abmv.Entidade.Aluno;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author X
 */
@ManagedBean
@RequestScoped
public class AlunoBean {

    private static int lastid;
    private static int id;
    private String nome;
    private String email;
    private String curso;
    private int periodo;

    /**
     * Creates a new instance of AlunoBean
     */

    public AlunoBean() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Collection<Aluno> getAll() {
        List<Aluno> array = (List<Aluno>) new CRUDAluno().getAll();
        lastid = 1;
        if (!array.isEmpty()) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).getId() > lastid) {
                    lastid = array.get(i).getId();
                }
            }
            lastid++;
        }
        return array;
    }

    public void salvar() {
        Aluno aluno;
        aluno = new Aluno();
        aluno.setId(lastid);
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setCurso(curso);
        aluno.setPeriodo(periodo);
        new CRUDAluno().persist(aluno);
    }

    public void remove(Aluno aluno) {
        new abmv.CRUD.CRUDAluno().remove(aluno);
    }

    public void update() {
        Aluno aluno;
        aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setCurso(curso);
        aluno.setPeriodo(periodo);
        new abmv.CRUD.CRUDAluno().update(aluno);
    }

    public void load_data(Aluno aluno) {
        id = aluno.getId();
        email = aluno.getEmail();
        nome = aluno.getNome();
        curso = aluno.getCurso();
        periodo = aluno.getPeriodo();
    }

    public Aluno getAluno() {
        return new Aluno();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Aluno;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vitor
 */
@ManagedBean
@RequestScoped
public class JsfAluno {

    /**
     * Creates a new instance of JsfAluno
     */
    public JsfAluno() {
    }

    private int id;
    private String curso;
    private String nome;
    private String email;
    private String cidade;
    private String estado;
    private String doc;
    private int periodo;
    private String nascimento;   
    
    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    public String goHome(){
        return "home.xhtml";
    }

    public void salvar() {
        Aluno aluno;
        aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setEmail(email);        
        aluno.setCurso(curso);
        aluno.setPeriodo(periodo);
        new abmv.CRUD.CRUDAluno().persist(aluno);
    }

    public java.util.Collection<Aluno> getAll() {
        return new abmv.CRUD.CRUDAluno().getAll();
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
        this.id = aluno.getId();
        this.email = aluno.getEmail();
        this.nome = aluno.getNome();
        this.curso = aluno.getCurso();
        this.periodo = aluno.getPeriodo();
    }

}

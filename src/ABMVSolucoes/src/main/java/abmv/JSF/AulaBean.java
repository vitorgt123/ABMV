/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.CRUD.CRUDConteudo;
import abmv.CRUD.CRUDDisciplina;
import abmv.Entidade.Conteudo;
import abmv.Entidade.ConteudoPK;
import abmv.Entidade.Disciplina;
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
    
    public void salvar(){
        disciplina.setQtdeaulas(disciplina.getQtdeaulas() + qtda);
        Conteudo cont = new Conteudo();
        cont.setConteudoPK(new ConteudoPK(disciplina.getId(), dia));
        cont.setDisciplina1(disciplina);
        cont.setDescricao(descricao);
        new CRUDConteudo().persist(cont);
        new CRUDDisciplina().update(disciplina);
    }
    
}

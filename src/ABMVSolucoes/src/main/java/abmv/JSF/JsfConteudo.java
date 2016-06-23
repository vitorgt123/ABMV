/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Conteudo;
import abmv.Entidade.Disciplina;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class JsfConteudo {
    private Disciplina disciplina;
    private String dia;
    private String descricao;

    public JsfConteudo() {
    }

    public JsfConteudo(Disciplina disciplina, String dia, String descricao) {
        this.disciplina = disciplina;
        this.dia = dia;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "JsfConteudo{" + "disciplina=" + disciplina + ", dia=" + dia + ", descricao=" + descricao + '}';
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
    
        public void salvar() {
        Conteudo conteudo;
        conteudo = new Conteudo(disciplina.getId(),dia);     
        conteudo.setDescricao(descricao);
        new abmv.CRUD.CRUDConteudo().persist(conteudo);
    }
    
//    public void valueChanged(Conteudo conteudo){
//        this.conteudo=conteudo;
//        System.out.println("Professor mudado "+conteudo.getNome());
//    }

    public java.util.Collection<Conteudo> getAll() {
        return new abmv.CRUD.CRUDConteudo().getAll();
    }

    public void remove(Disciplina disciplina) {
        new abmv.CRUD.CRUDDisciplina().remove(disciplina);
    }

    public void update() {
        Conteudo conteudo;
        conteudo = new Conteudo(disciplina.getId(),dia);     
        conteudo.setDescricao(descricao);
        new abmv.CRUD.CRUDConteudo().update(conteudo);
    }

    public void load_data(Conteudo conteudo) {
        this.descricao = conteudo.getDescricao();
        this.dia= conteudo.getConteudoPK().getDia();
        this.disciplina = conteudo.getDisciplina1();
    }
}

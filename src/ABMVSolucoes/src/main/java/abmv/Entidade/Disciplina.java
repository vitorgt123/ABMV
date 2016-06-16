/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.Entidade;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author X
 */
@Entity
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findById", query = "SELECT d FROM Disciplina d WHERE d.id = :id"),
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome"),
    @NamedQuery(name = "Disciplina.findByCurso", query = "SELECT d FROM Disciplina d WHERE d.curso = :curso"),
    @NamedQuery(name = "Disciplina.findByQtdeaulas", query = "SELECT d FROM Disciplina d WHERE d.qtdeaulas = :qtdeaulas")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "curso")
    private String curso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtdeaulas")
    private int qtdeaulas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina1")
    private Collection<Conteudo> conteudoCollection;
    @JoinColumn(name = "professor", referencedColumnName = "id")
    @ManyToOne
    private Professor professor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private Collection<Matricula> matriculaCollection;

    public Disciplina() {
    }

    public Disciplina(Integer id) {
        this.id = id;
    }

    public Disciplina(Integer id, String nome, String curso, int qtdeaulas) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.qtdeaulas = qtdeaulas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getQtdeaulas() {
        return qtdeaulas;
    }

    public void setQtdeaulas(int qtdeaulas) {
        this.qtdeaulas = qtdeaulas;
    }

    @XmlTransient
    public Collection<Conteudo> getConteudoCollection() {
        return conteudoCollection;
    }

    public void setConteudoCollection(Collection<Conteudo> conteudoCollection) {
        this.conteudoCollection = conteudoCollection;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abmv.Entidade.Disciplina[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.Entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author X
 */
@Entity
@Table(name = "conteudo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conteudo.findAll", query = "SELECT c FROM Conteudo c"),
    @NamedQuery(name = "Conteudo.findByDisciplina", query = "SELECT c FROM Conteudo c WHERE c.conteudoPK.disciplina = :disciplina"),
    @NamedQuery(name = "Conteudo.findByDia", query = "SELECT c FROM Conteudo c WHERE c.conteudoPK.dia = :dia"),
    @NamedQuery(name = "Conteudo.findByDescricao", query = "SELECT c FROM Conteudo c WHERE c.descricao = :descricao")})
public class Conteudo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConteudoPK conteudoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "disciplina", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina1;

    public Conteudo() {
    }

    public Conteudo(ConteudoPK conteudoPK) {
        this.conteudoPK = conteudoPK;
    }

    public Conteudo(ConteudoPK conteudoPK, String descricao) {
        this.conteudoPK = conteudoPK;
        this.descricao = descricao;
    }

    public Conteudo(int disciplina, String dia) {
        this.conteudoPK = new ConteudoPK(disciplina, dia);
    }

    public ConteudoPK getConteudoPK() {
        return conteudoPK;
    }

    public void setConteudoPK(ConteudoPK conteudoPK) {
        this.conteudoPK = conteudoPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Disciplina getDisciplina1() {
        return disciplina1;
    }

    public void setDisciplina1(Disciplina disciplina1) {
        this.disciplina1 = disciplina1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conteudoPK != null ? conteudoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conteudo)) {
            return false;
        }
        Conteudo other = (Conteudo) object;
        if ((this.conteudoPK == null && other.conteudoPK != null) || (this.conteudoPK != null && !this.conteudoPK.equals(other.conteudoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abmv.Entidade.Conteudo[ conteudoPK=" + conteudoPK + " ]";
    }
    
}

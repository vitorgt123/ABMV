/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.Entidade;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author X
 */
@Entity
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByMatricula", query = "SELECT a FROM Avaliacao a WHERE a.avaliacaoPK.matricula = :matricula"),
    @NamedQuery(name = "Avaliacao.findByPeso", query = "SELECT a FROM Avaliacao a WHERE a.peso = :peso"),
    @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota"),
    @NamedQuery(name = "Avaliacao.findByNome", query = "SELECT a FROM Avaliacao a WHERE a.avaliacaoPK.nome = :nome")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvaliacaoPK avaliacaoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private BigInteger peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private BigInteger nota;
    @JoinColumn(name = "matricula", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matricula matricula1;

    public Avaliacao() {
    }

    public Avaliacao(AvaliacaoPK avaliacaoPK) {
        this.avaliacaoPK = avaliacaoPK;
    }

    public Avaliacao(AvaliacaoPK avaliacaoPK, BigInteger peso, BigInteger nota) {
        this.avaliacaoPK = avaliacaoPK;
        this.peso = peso;
        this.nota = nota;
    }

    public Avaliacao(int matricula, String nome) {
        this.avaliacaoPK = new AvaliacaoPK(matricula, nome);
    }

    public AvaliacaoPK getAvaliacaoPK() {
        return avaliacaoPK;
    }

    public void setAvaliacaoPK(AvaliacaoPK avaliacaoPK) {
        this.avaliacaoPK = avaliacaoPK;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public BigInteger getNota() {
        return nota;
    }

    public void setNota(BigInteger nota) {
        this.nota = nota;
    }

    public Matricula getMatricula1() {
        return matricula1;
    }

    public void setMatricula1(Matricula matricula1) {
        this.matricula1 = matricula1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaliacaoPK != null ? avaliacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.avaliacaoPK == null && other.avaliacaoPK != null) || (this.avaliacaoPK != null && !this.avaliacaoPK.equals(other.avaliacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abmv.Entidade.Avaliacao[ avaliacaoPK=" + avaliacaoPK + " ]";
    }
    
}

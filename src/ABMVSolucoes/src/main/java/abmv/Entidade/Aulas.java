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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author X
 */
@Entity
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a"),
    @NamedQuery(name = "Aulas.findByMatricula", query = "SELECT a FROM Aulas a WHERE a.aulasPK.matricula = :matricula"),
    @NamedQuery(name = "Aulas.findByDia", query = "SELECT a FROM Aulas a WHERE a.aulasPK.dia = :dia"),
    @NamedQuery(name = "Aulas.findByFaltas", query = "SELECT a FROM Aulas a WHERE a.faltas = :faltas")})
public class Aulas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AulasPK aulasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "faltas")
    private int faltas;
    @JoinColumn(name = "matricula", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matricula matricula1;

    public Aulas() {
    }

    public Aulas(AulasPK aulasPK) {
        this.aulasPK = aulasPK;
    }

    public Aulas(AulasPK aulasPK, int faltas) {
        this.aulasPK = aulasPK;
        this.faltas = faltas;
    }

    public Aulas(int matricula, String dia) {
        this.aulasPK = new AulasPK(matricula, dia);
    }

    public AulasPK getAulasPK() {
        return aulasPK;
    }

    public void setAulasPK(AulasPK aulasPK) {
        this.aulasPK = aulasPK;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
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
        hash += (aulasPK != null ? aulasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.aulasPK == null && other.aulasPK != null) || (this.aulasPK != null && !this.aulasPK.equals(other.aulasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abmv.Entidade.Aulas[ aulasPK=" + aulasPK + " ]";
    }
    
}

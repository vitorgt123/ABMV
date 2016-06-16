/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Vitor
 */
@Entity
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a"),
    @NamedQuery(name = "Aulas.findByFaltas", query = "SELECT a FROM Aulas a WHERE a.faltas = :faltas"),
    @NamedQuery(name = "Aulas.findByDia", query = "SELECT a FROM Aulas a WHERE a.dia = :dia"),
    @NamedQuery(name = "Aulas.findById", query = "SELECT a FROM Aulas a WHERE a.id = :id")})
public class Aulas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "faltas")
    private Integer faltas;
    @Size(max = 2147483647)
    @Column(name = "dia")
    private String dia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "matricula_id", referencedColumnName = "id")
    @ManyToOne
    private Matricula matriculaId;

    public Aulas() {
    }

    public Aulas(Integer id) {
        this.id = id;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matricula getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Matricula matriculaId) {
        this.matriculaId = matriculaId;
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
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abmv.Entidades.Aulas[ id=" + id + " ]";
    }
    
}

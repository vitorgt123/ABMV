/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.Entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author X
 */
@Embeddable
public class AulasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private int matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "dia")
    private String dia;

    public AulasPK() {
    }

    public AulasPK(int matricula, String dia) {
        this.matricula = matricula;
        this.dia = dia;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) matricula;
        hash += (dia != null ? dia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AulasPK)) {
            return false;
        }
        AulasPK other = (AulasPK) object;
        if (this.matricula != other.matricula) {
            return false;
        }
        if ((this.dia == null && other.dia != null) || (this.dia != null && !this.dia.equals(other.dia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abmv.Entidade.AulasPK[ matricula=" + matricula + ", dia=" + dia + " ]";
    }
    
}

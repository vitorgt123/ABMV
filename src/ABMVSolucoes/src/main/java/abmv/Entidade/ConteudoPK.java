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
public class ConteudoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "disciplina")
    private int disciplina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "dia")
    private String dia;

    public ConteudoPK() {
    }

    public ConteudoPK(int disciplina, String dia) {
        this.disciplina = disciplina;
        this.dia = dia;
    }

    public int getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(int disciplina) {
        this.disciplina = disciplina;
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
        hash += (int) disciplina;
        hash += (dia != null ? dia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConteudoPK)) {
            return false;
        }
        ConteudoPK other = (ConteudoPK) object;
        if (this.disciplina != other.disciplina) {
            return false;
        }
        if ((this.dia == null && other.dia != null) || (this.dia != null && !this.dia.equals(other.dia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abmv.Entidade.ConteudoPK[ disciplina=" + disciplina + ", dia=" + dia + " ]";
    }
    
}

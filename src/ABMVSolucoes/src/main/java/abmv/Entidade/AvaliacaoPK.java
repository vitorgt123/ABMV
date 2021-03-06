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
public class AvaliacaoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private int matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;

    public AvaliacaoPK() {
    }

    public AvaliacaoPK(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) matricula;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoPK)) {
            return false;
        }
        AvaliacaoPK other = (AvaliacaoPK) object;
        if (this.matricula != other.matricula) {
            return false;
        }
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abmv.Entidade.AvaliacaoPK[ matricula=" + matricula + ", nome=" + nome + " ]";
    }
    
}

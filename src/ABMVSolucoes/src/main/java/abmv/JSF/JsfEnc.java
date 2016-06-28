/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

/**
 *
 * @author Marcelo
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class JsfEnc {

    public JsfEnc() {
    }

    public String goAlunos() {
        return "cadaluno.xhtml";
    }

    public String goProfessores() {
        return "cadprof.xhtml";
    }

    public String goDisciplinas() {
        return "caddisc.xhtml";
    }

    public String goMatricula() {
        return "cadmatr.xhtml";
    }

    public String goConteudo() {
        return "cadfaltas.xhtml";
    }

    public String goNotas() {
        return "cadnota.xhtml";
    }

    public String goViewNotas() {
        return "viewNotas.xhtml";
    }

    public String goViewFaltas() {
        return "viewfaltas.xhtml";
    }

    public String goHome() {
        return "home.xhtml";
    }

}

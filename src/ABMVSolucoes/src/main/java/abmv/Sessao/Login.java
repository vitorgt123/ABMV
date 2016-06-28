/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.Sessao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vitor
 */

@ManagedBean
@SessionScoped
public class Login {

    private String opcao;

    public String doLogin() {
        if (opcao.equals("Admin")) {
            HttpSession hs = Sessao.getSession();
            hs.setAttribute("opcao", opcao);
            return "/mainadmin.xhtml";
        } else if (opcao.equals("Aluno")) {
            return "/mainaluno.xhtml";
        } else if (opcao.equals("Professor")) {
            return "/mainprofessor.xhtml";
        } else {
            FacesMessage fm = new FacesMessage("Erro de login", "ERROR MSG");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/home.xhtml";
        }
    }

    public String doLogout() {
        HttpSession hs = Sessao.getSession();
        hs.invalidate();
        return "/home.xhtml";
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

}

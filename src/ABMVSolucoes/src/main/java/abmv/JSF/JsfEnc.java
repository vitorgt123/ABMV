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
    public JsfEnc(){        
    }
    
    public String goAlunos(){
        return "alunos.xhtml";
    }
    public String goProfessores(){
        return "professores.xhtml";
    }
    public String goDisciplinas(){
        return "disciplinas.xhtml";
    }
    
    public String goMatricula(){
        return "matricula.xhtml";
    }
    
    public String goHome(){
        return "home.xhtml";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Avaliacao;
import abmv.Entidade.AvaliacaoPK;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Debrino
 */
public class ViewNotasBeanTest {
    
    public ViewNotasBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getReajuste method, of class ViewNotasBean.
     */
    private static int notatotal;
    private static int total;
    private static int n1;
    private static int p1;
    private static int reajuste;
    private static List<Avaliacao> avaliacao;
    
    @Test
    public void test3(){
        avaliacao = new ArrayList();
        avaliacao.add(new Avaliacao(new AvaliacaoPK(1,"p1"),10,8));
        avaliacao.add(new Avaliacao(new AvaliacaoPK(1,"p2"),10,10));
        avaliacao.add(new Avaliacao(new AvaliacaoPK(1,"p3"),10,6));
        avaliacao.add(new Avaliacao(new AvaliacaoPK(1,"p4"),10,8));
        CalcMedia();
        if(notatotal<total){
            Assert.assertTrue(true);
        } else{
            Assert.assertTrue(false);
        }
    }
    
    @Test
    public void test4(){
        avaliacao = new ArrayList();
        avaliacao.add(new Avaliacao(new AvaliacaoPK(1,"p1"),10,8));
        avaliacao.add(new Avaliacao(new AvaliacaoPK(1,"p2"),10,10));
        avaliacao.add(new Avaliacao(new AvaliacaoPK(1,"p3"),10,6));
        avaliacao.add(new Avaliacao(new AvaliacaoPK(1,"p4"),10,8));
        CalcMedia();
        if(notatotal>reajuste){
            Assert.assertTrue(true);
        } else{
            Assert.assertTrue(false);
        }
    }
    
    public void CalcMedia() {
        notatotal = 0;
        total = 0;

        for (int i = 0; i < avaliacao.size(); i++) {
            n1 = avaliacao.get(i).getNota();
            p1 = avaliacao.get(i).getPeso();
            notatotal = notatotal + n1;
            total = total + p1;                        
        }
        
        Ajuste();
    }
    
    public void Ajuste(){
        reajuste = (notatotal*10) / total;
    }
    
}

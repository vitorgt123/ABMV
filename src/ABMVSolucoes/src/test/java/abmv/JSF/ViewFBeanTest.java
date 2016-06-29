/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmv.JSF;

import abmv.Entidade.Aulas;
import abmv.Entidade.AulasPK;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Debrino
 */
public class ViewFBeanTest {
    
    public ViewFBeanTest() {
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
     * Test of getPocentagem method, of class ViewFBean.
     */
    
    private static List<Aulas> aulas;
    private static int total;
    private static int faltas;
    private static int pocentagem;
    
    @Test
    public void teste1(){
        aulas = new ArrayList();
        aulas.add(new Aulas(new AulasPK(1,"1"),2));
        aulas.add(new Aulas(new AulasPK(1,"2"),0));
        aulas.add(new Aulas(new AulasPK(1,"3"),0));
        aulas.add(new Aulas(new AulasPK(1,"4"),2));
        aulas.add(new Aulas(new AulasPK(1,"5"),0));
        aulas.add(new Aulas(new AulasPK(1,"6"),0));
        aulas.add(new Aulas(new AulasPK(1,"7"),2));
        total = 14;
        calc();
        if(faltas <= total){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
    
    @Test
    public void teste2(){
        aulas = new ArrayList();
        aulas.add(new Aulas(new AulasPK(1,"1"),2));
        aulas.add(new Aulas(new AulasPK(1,"2"),2));
        aulas.add(new Aulas(new AulasPK(1,"3"),2));
        aulas.add(new Aulas(new AulasPK(1,"4"),2));
        aulas.add(new Aulas(new AulasPK(1,"5"),2));
        aulas.add(new Aulas(new AulasPK(1,"6"),2));
        aulas.add(new Aulas(new AulasPK(1,"7"),2));
        total = 14;
        calc();
        if(faltas <= total){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
    
    public void calc() {
        faltas = 0;
        for (int i = 0; i < aulas.size(); i++) {
            faltas += aulas.get(i).getFaltas();
        }
        pocentagem = 100 - (faltas / total * 100);
    }
    
}

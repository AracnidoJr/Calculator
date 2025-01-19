/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CALCULADORA;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *@author Ricardo Illescas
 * @author Santiago Olvera
 * @author Mauricio Vázquez
 * @author Emmanuel Rosales
 * @author Iván Vázquez
 */
public class CalcuTest {
    
    public CalcuTest() {
    }

    /**
     * Test of verificacion method, of class Calcu.
     */
    @Test
    public void testVerificacion() {     //Hicimos un String con valores que darian falso, asi como verdaderos
        Calcu calc;
        String[] calculo2={"(99*2/4.3+3/2", "(99*2)//4.3+3/2", "(99*2)/4.3+3/2)", "(99*2/4.3+3/2", "0..7+0.8","+9","(+9)","_66_77","(5)9","_(9)_-6","0.5+.5",".5","(0.5).7","0.5-_.9","0.+5","(.8)+2","_(_24*7)", "_(24)"};
        String[] calculos={"(99*2)/4.3+3/2", "99*2", "99/4.3", "4.3+3", "(454.5/1.5)+0.3*(6.3+3.7)", "0/3", "3/0","0.5+0.5", "0.55+0.45","10000000000000000000000+1","0.9+0.9","_9+2","_0.5+3","_9/1","(5)-(_5)", "0.5-_0.4"};
        for(int i=0;i<calculos.length;i++){
            calc=new Calcu(calculos[i]);
            boolean resultadoE=true;
            boolean resultado=calc.verificacion();
            assertEquals(resultadoE, resultado);
        }
        for(int i=0;i<calculo2.length;i++){
            calc=new Calcu(calculo2[i]);
            boolean resultadoE=false;
            boolean resultado=calc.verificacion();
            assertEquals(resultadoE, resultado);
        }
        
    }
    
    @Test
    public void testInfijoaPosfijo(){           //Comprobamos los que dieron verdero en el inciso anterior ya que en la interface ya no se evaluan los falsos de verificacion
        Calcu calc;
        String[] calculos={"(99*2)/4.3+3/2", "99*2", "99/4.3", "4.3+3", "(454.5/1.5)+0.3*(6.3+3.7)", "0/3", "3/0","0.5+0.5", "0.55+0.45","10000000000000000000000+1","0.9+0.9","_9+2","_0.5+3","_9/1","(5)-(_5)", "0.5-_0.4"};
        
        calc= new Calcu("(99*2)/4.3+3/2");
        String resultadoE="9 92*4.3/32/+";
        String resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("99*2");
        resultadoE="9 92*";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("99/4.3");
        resultadoE="9 94.3/";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("4.3+3");
        resultadoE="4.33+";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("(454.5/1.5)+0.3*(6.3+3.7)");
        resultadoE="4 5 4.51.5/0.36.33.7+*+";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("0/3");
        resultadoE="03/";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("3/0");
        resultadoE="30/";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("0.5+0.5");
        resultadoE="0.50.5+";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("0.55+0.45");
        resultadoE="0.5 50.4 5+";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("10000000000000000000000+1");
        resultadoE="1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 01+";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("0.9+0.9");
        resultadoE="0.90.9+";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("_9+2");
        resultadoE="_92+";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("_0.5+3");
        resultadoE="_0.53+";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("_9/1");
        resultadoE="_91/";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("(5)-(_5)");
        resultadoE="5_5-";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
        
        calc.setInfijo("0.5-_0.4");
        resultadoE="0.5_0.4-";
        resultado=calc.infijoAPostfijo();
        assertEquals(resultadoE, resultado);
    }
    
    @Test
    public void testEvaluar(){       //Evaluando los postfijos
        Calcu calc;
        String[] calculos={"(99*2)/4.3+3/2", "99*2", "99/4.3", "4.3+3", "(454.5/1.5)+0.3*(6.3+3.7)", "0/3", "3/0","0.5+0.5", "0.55+0.45","10000000000000000000000+1","0.9+0.9","_9+2","_0.5+3","_9/1","(5)-(_5)", "0.5-_0.4"};
        
        calc= new Calcu("(99*2)/4.3+3/2");
        double resultadoE=47.54651162790698;
        double resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("99*2");
        resultadoE=198.0;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("99/4.3");
        resultadoE=23.02325581395349;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("4.3+3");
        resultadoE=7.3;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("(454.5/1.5)+0.3*(6.3+3.7)");
        resultadoE=306.0;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("0/3");
        resultadoE=0.0;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("0.5+0.5");
        resultadoE=1.0;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("0.55+0.45");
        resultadoE=1.0;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("10000000000000000000000+1");
        resultadoE=1.0E22;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("0.9+0.9");
        resultadoE=1.8;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("_9+2");
        resultadoE=-7.0;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("_0.5+3");
        resultadoE=2.5;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("_9/1");
        resultadoE=-9.0;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("(5)-(_5)");
        resultadoE=10.0;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
        
        calc.setInfijo("0.5-_0.4");
        resultadoE=0.9;
        resultado=calc.evaluar();
        assertEquals(resultadoE, resultado,0.0);
    }
    
}

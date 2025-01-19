
package Calculadora;

/**
 * @author Ricardo Illescas
 * @author Santiago Olvera
 * @author Mauricio Vázquez
 * @author Emmanuel Rosales
 * @author Iván Vázquez
 * Clase para probar el funcionamienrto de la clase Calcu
 */

 /**
 * 10 pruebas para probar el funcionamiento de la clase Calcu
 */
public class Calcu_Pruebas {
   public static void main(String[] args) {
        Calcu calc, calc2, calc3, calc4,calc5,calc6,calc7,calc8,calc9,calc10;
        String[] calculos={"(99*2)/4.3+3/2", "(99*2/4.3+3/2", "(99*2)//4.3+3/2", "(99*2)/4.3+3/2)", "(99*2/4.3+3/2", "99*2", "99/4.3", "4.3+3", "(99*2)/4.3+3/2", "(454.5/1.5)+0.3*(6.3+3.7)", "0/3", "3/0","0.5+0.5", "0.55+0.45","10000000000000000000000+1","0..7+0.8","+9","(+9)","0.9+0.9","_9+2","_0.5+3","_9/1","(5)-(_5)","_66_77","(5)9","_(9)_-6","0.5+.5",".5","(0.5).7","0.5-_.9", "0.5-_0.4","0.+5","(.8)+2","_(_24*7)", "_(24)"};
        
        for(int i=0; i<calculos.length; i++){
            System.out.println("\n"+(i+1)+". \n");
            try{
                calc= new Calcu(calculos[i]);
                System.out.println(calc.verificacion());
                System.out.println(calc.infijoAPostfijo());
                System.out.println(calc.evaluar());
            }
            catch(Exception e){
                System.out.println("Mal escrito");
            }
        }
    } 
}

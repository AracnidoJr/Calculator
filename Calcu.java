/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Ricardo Illescas
 * @author Santiago Olvera
 * @author Mauricio Vázquez
 * @author Emmanuel Rosales
 * @author Iván Vázquez
 * 
 * Creacion de la clase Calcu con metodos para el optimo funcionamiento de una calculadora con pilas
 */

public class Calcu {
    private String infijo;
    
     /**
     * Constructor vacio de la clase Calcu
     */
    public Calcu() {
    }

     /**
     * Constructor de la clase Calcu
     * @param infijo de tipo String que recibe para el uso de los siguientes metodos 
     */
    public Calcu(String infijo) {
        this.infijo = infijo;
    }
	
	
    /**
     *
     * @return
     */	
    public boolean verificacion(){
        PilaA<Character> cad = new PilaA();
        boolean aux= true;
        int i=0;
        
        while(i<infijo.length() && aux){
            if(infijo.charAt(i)=='(')
                cad.push(infijo.charAt(i));
            else
                if(infijo.charAt(i)==')'){
                    if(!cad.isEmpty())
                        cad.pop();
                    else
                        aux=false;
                }
             if ((operando(infijo.charAt(i)) && (i==0 || operando(infijo.charAt(i-1)) || infijo.charAt(i-1)=='(' || infijo.charAt(i-1)=='.')) || (infijo.charAt(i)=='.' && (i==0 || infijo.charAt(i-1)=='.' || infijo.charAt(i-1)==')' || infijo.charAt(i-1)=='(' || operando(infijo.charAt(i-1)) || infijo.charAt(i-1)=='_')) || (i!=0 && ((infijo.charAt(i)=='_' && (infijo.charAt(i-1)=='_' || Character.isDigit(infijo.charAt(i-1)) || infijo.charAt(i-1)=='.')) || (infijo.charAt(i)=='(' && infijo.charAt(i-1)=='_') || (infijo.charAt(i-1)==')' && Character.isDigit(infijo.charAt(i)))))) {
                aux=false;
            } 
            i++;
        }
        if(!cad.isEmpty())
                aux=false;
        return aux;
    }
	
    /**
     *
     * @param ch
     * @return
     */
    public boolean operando(Character ch){
        boolean res= false;
        
        if(ch=='+' || ch=='*' || ch=='-' || ch=='/')
            res=true;
        return res;
    }
	
    /**
     *
     * @return
     */
    private static int jerarquia(Character op) {
    int prf = 99;
    if (op.equals('*') || op.equals('/')) prf = 4;
    if (op.equals('+') || op.equals('-')) prf = 3;
    if (op.equals(')')) prf = 2;
    if (op.equals('(')) prf = 1;
    return prf;
  }
	
    /**
     *
     * @return
     */
    public String infijoAPostfijo(){
        StringBuilder str= new StringBuilder();
        PilaA<Character> cad = new PilaA();
        str.append("");
        
        if(verificacion()){
            for(int i=0;i<infijo.length();i++){
                if(Character.isDigit(infijo.charAt(i)) || infijo.charAt(i)=='.' || infijo.charAt(i)=='_'){
                    if(i!=0 && Character.isDigit(infijo.charAt(i-1)) && infijo.charAt(i)!='.' && infijo.charAt(i)!='_'){
                        str.append(" ");
                        str.append(infijo.charAt(i));
                    }
                    else
                        str.append(infijo.charAt(i));
                }    
                    
                else
                    if(infijo.charAt(i)=='(')
                        cad.push('(');
                    else
                        if(infijo.charAt(i)==')'){
                            while(cad.peeek()!='('){
                                str.append(cad.pop());
                            }
                            cad.pop();
                        }
                        else
                            if(!cad.isEmpty() && jerarquia(infijo.charAt(i))<= jerarquia(cad.peeek())){
                                str.append(cad.pop());
                                cad.push(infijo.charAt(i));
                            }
                            
                            else
                                cad.push(infijo.charAt(i));
                            
                            
            }
            while(!cad.isEmpty())
                str.append(cad.pop());
        }
        return str.toString();
    }
	
    /**
     *
     * @return
     */
    public double evaluar(){
        double res;
        PilaA<String> cad = new PilaA();
        String str=infijoAPostfijo();
        boolean aux=true;
        String aux2="";
        
        for(int i=0;i<str.length();i++){
            if(!aux){
                    if(str.charAt(i-1)==' '){
                        aux2=cad.pop();
                        aux2=aux2+str.charAt(i);
                    }
                    else{
                        if(str.charAt(i-1)=='.'){
                            aux2=cad.pop();
                            aux2=aux2+"."+str.charAt(i);
                        }
                        else{
                            aux2="-"+str.charAt(i);
                        }
                    }
                    cad.push(aux2);
                    aux2="";
                    aux=true;
            }
            else
                if(Character.isDigit(str.charAt(i)))
                    cad.push(Character.toString(str.charAt(i)));
                else
                    if(str.charAt(i)==' ' || str.charAt(i)=='.' || str.charAt(i)=='_')
                        aux=false;
                    else
                        switch (str.charAt(i)) {
			case  '+': cad.push(String.valueOf(Double.parseDouble(cad.pop())+Double.parseDouble(cad.pop())));
				break;
			case '-': cad.push(String.valueOf(-Double.parseDouble(cad.pop())+Double.parseDouble(cad.pop())));
				break;
			case  '*': cad.push(String.valueOf(Double.parseDouble(cad.pop())*Double.parseDouble(cad.pop())));
				break;
			case  '/': cad.push(String.valueOf(1/(Double.parseDouble(cad.pop())/Double.parseDouble(cad.pop()))));
				break;
			default:;
			}        
        }
        res=Double.parseDouble(cad.pop());
        return res;
    }
    
}

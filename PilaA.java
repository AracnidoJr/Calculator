package PilaAndException;

/**
 *
 * @author Iván Vázquez
 * @param <T> de tipo generico para poder recibir pilas de cualquier tipo
 * 
 * Creación de la clase PilaA
 */
public class PilaA <T> implements PilaADT<T> {

    private T[] pila;
    private int tope;
    private final int MAXIMO = 20;
    
    /**
     * Constructor de la clase PilaA
     */
    public PilaA() {
        pila = (T[]) new Object[MAXIMO];
        tope = -1;
    }
    
    /**
     * Metodo que se utiliza para ingresar datos a una pila
     * @param dato de tipo T (generico) el cual sera el dato a introducir en la pila
     */
    public void push(T dato) {
        if(tope==pila.length-1)
            expands();
        tope++;
        pila[tope]= (T) dato;
    }
    
    /**
     * Metodo que se utiliza para expandir el tamaño de la pila 
     */
    private void expands(){
        T[] nuevo = (T[]) new Object[pila.length*2];
        
        for(int i=0; i<= tope; i++)
            nuevo[i]=pila[i];
        pila=nuevo;
    }

    /**
     * Metodo que elimina un objeto de la pila
     * @return de tipo generico que regresa el dato que se elimino
     */
    public T pop() {
        T resultado;

        if (this.isEmpty()) {
            throw new ColeccionVacio("Pila Vacia");
        }
        resultado = pila[tope];
        tope--;

        return resultado;
    }

    /**
     * Metodo que sirvbe para ver si una pila esta vacia o no
     * @return de tipo booleano que regresa true si esta vacia la pila o false si no esta vacia la pila
     */
    public boolean isEmpty() {
        boolean res = false;

        if (tope == -1) {
            res = true;
        }

        return res;
    }

    /**
     * Metodo que sirve para ver el dato que esta hasta la cima de la pila
     * @return de tipo T (generico) que regresa el dato que esta hasta arriba de la pila
     */
    public T peek() {

        if (this.isEmpty()) {
            throw new ColeccionVacio("Pila Vacia");
        }

        return pila[tope];
    }
    
    /**
     * Metodo que imprime los datos de la pila
     * @return de tipo String que regresa los datos que estan dentro de la pila
     */
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        for(int i=0; i<= tope; i++){
            cad.append(pila[i]).append("\n");
        }
        return cad.toString();
    }

}

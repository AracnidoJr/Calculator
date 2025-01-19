
package PilaAndException;

/**
 *
 * @author Iván Vázquez
 * Febrero 2022
 * Clase ColecciónVacio que extiende RuntimeException en caso de que una pila este vacia
 */
public class ColeccionVacio extends RuntimeException {
    
    /**
     * Constructor vacio de la clase ColeccionVacio
     */
    public ColeccionVacio(){
        super();
    }
    
    /**
     * Constructor de la clase ColeccionVacio que recibe como parametros:
     * @param mensaje de tipo String, el cual lanza al momento en el que se llama a la clase.
     */
    public ColeccionVacio(String mensaje){
        super(mensaje);
    }
    
}

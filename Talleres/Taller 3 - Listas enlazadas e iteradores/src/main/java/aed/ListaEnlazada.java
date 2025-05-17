package aed;

// Declara una clase pública y genérica ListaEnlazada que implementa la interfaz Secuencia<T>
public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo prim;
    private Nodo ult;
    private int tamaño;

    // Representa cada elemento de la lista. 
    //Guarda un valor genérico valor, y referencias al siguiente (sig) y anterior (ant) nodo.
    private class Nodo {
        T valor;
        Nodo sig;
        Nodo ant;
        public Nodo(T v){
            valor=v;
        }
    }
    // Inicializa la lista como vacía.
    public ListaEnlazada() {
        this.prim = null;
        this.ult=null;
        tamaño=0;

    }

    public int longitud() {
        return tamaño;
    }
    // Crea un nuevo nodo al principio de la lista.
    //Si la lista ya tiene nodos, actualiza el anterior del nodo viejo.
    //Actualiza el puntero prim.
    public void agregarAdelante(T elem) {
        Nodo nuev = new Nodo(elem);
        nuev.sig=this.prim;
        nuev.ant = null;
        if (prim != null){
            prim.ant = nuev;
        }
        prim = nuev;
        tamaño++;
    }
    // Inserta un nodo al final de la lista.
    // Si está vacía, se convierte en el primer nodo.
    // Si no, se recorre hasta el final y se enlaza al nuevo nodo.

    public void agregarAtras(T elem) {
        Nodo nuev = new Nodo(elem);
        nuev.sig = null;
        if(prim == null){
            nuev.ant = null;
            prim = nuev;
        }else{
            Nodo actual = prim;
            while (actual.sig != null){
                actual = actual.sig;
            }
            actual.sig = nuev;
            nuev.ant = actual;
        }
        tamaño++;
    }
    // Usa un iterador para avanzar i posiciones y devolver el elemento en esa posición.
    public T obtener(int i) {
        ListaIterador iterador = new ListaIterador();
        for (int j=0;j<i;j++){
            iterador.siguiente(); // termina cuando apunta al nodo en la posicion i-1
        }
        return iterador.siguiente(); // estoy en la posicion i
    }
    // Elimina el nodo en la posición i.
    //Usa el iterador para posicionarse.
    //Actualiza los enlaces de los nodos vecinos.
    public void eliminar(int i) {
        ListaIterador iterador = new ListaIterador();
        for(int j = 0; iterador.haySiguiente() && j<i; j++){
            iterador.siguiente();
        }
         // Una vez finalizado el ciclo, tengo en iterador.actual.sig al Nodo que quiero eliminar
        // Si el nodo a ser eliminado es el primero, digo que el nuevo primero será el siguiente al eliminado
        if(prim == iterador.actual.sig){
            prim = iterador.actual.sig.sig;
        }
         // Si el nodo no es el último, fijo que el previo del siguiente sea el de indice dos atras
        // Ej en [1,2,3,4,5] elimino 3, fijo que el prev de 4 sea 2
        if(iterador.actual.sig.sig !=null){ // iterador.actual apunta al nodo con valor 2.
            iterador.actual.sig.sig.ant = iterador.actual.sig.ant; // [4].ant = [3].ant = [2]
        }
        // Si el nodo no es el primero, fijo que el siguiente del previo sea el de indice dos adelante
        // Ej en [1,2,3,4,5] elimino 3, fijo que el sig de 2 sea 4
        if(iterador.actual.sig.ant !=null){
            iterador.actual.sig.ant.sig = iterador.actual.sig.sig; // [2].sig = [3].sig = [4]
        }
        tamaño--;

    }
    // Modifica el valor del nodo en la posición indice.
    public void modificarPosicion(int indice, T elem) {
        ListaIterador iterador = new ListaIterador();
        for(int i = 0; iterador.haySiguiente() && i<indice; i++){
            iterador.siguiente();
        }
        iterador.actual.sig.valor = elem; // iterador.actual.sig es el nodo en la posición indice.
        //iterador.actual es el nodo en la posición indice - 1.
    }
    // Constructor que copia otra lista enlazada usando agregarAtras.
    public ListaEnlazada(ListaEnlazada<T> lista) {
        for(int j = 0; j<lista.longitud();j++){
            this.agregarAtras(lista.obtener(j));
        }
    }
    //n Devuelve una representación en string de la lista, como [a, b, c].
    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        ListaIterador iterador = new ListaIterador();
        sbuffer.append('[');
        while (iterador.haySiguiente()) {
            sbuffer.append(iterador.siguiente().toString()+", ");
        }
        sbuffer.delete(sbuffer.length()-2, sbuffer.length());
        sbuffer.append(']');
        return sbuffer.toString();
    }
    // Implementa un iterador para recorrer la lista.
    private class ListaIterador implements Iterador<T> {
    	private Nodo actual = new Nodo(null);
        // Inicializa el iterador justo "antes" del primer nodo.
        public ListaIterador(){
            actual.sig = prim;
            actual.ant = null;
        }
        
        public boolean haySiguiente() {
	        return actual.sig != null;
        }
        
        public boolean hayAnterior() {
	        return actual.ant != null;
        }
        // Avanza una posición y devuelve el valor del nodo visitado.
        public T siguiente() {
	        actual.ant = actual.sig;
            actual.sig = actual.sig.sig;
            return actual.ant.valor;
        }
        // Retrocede una posición y devuelve el valor.
        public T anterior() {
	        actual.sig = actual.ant;
            actual.ant = actual.ant.ant;
            return actual.sig.valor;
        }
    }
    // Permite acceder a un iterador externo para recorrer la lista
    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}

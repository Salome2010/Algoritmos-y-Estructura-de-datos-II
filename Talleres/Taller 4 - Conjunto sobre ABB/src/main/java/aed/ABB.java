package aed;
import java.util.Stack;
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int cardinal;
    private int altura;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;

        private Nodo(T v){
            valor = v;
            izq = null;
            der = null;
        }
        
        // Crear Constructor del nodo
    }

    public ABB() {
        raiz=null;
        cardinal = 0;
        altura = 0;
    }
    public ABB(Nodo raizNueva){
        raiz = raizNueva;
    }
    public int cardinal() {
        return this.cardinal;
    }

    public T minimo(){
        return minimoAyuda(raiz); // Comienzo en la raíz del árbol, desde donde busco el valor mínimo recorriendo hacia la izquierda
    }
    public T minimoAyuda(Nodo nodo){
        if(nodo.izq==null){
            return nodo.valor;
        }else{
             // Recorre recursivamente la rama izquierda hasta encontrar 
             //el nodo con el valor mínimo (el más a la izquierda)
            return minimoAyuda(nodo.izq); 
        }
    }

    public T maximo(){
        return maximoAyuda(raiz);    
    }

    public T maximoAyuda(Nodo nodo){
        if(nodo.der==null){
            return nodo.valor;
        }else{ // recursivamente con minimoAyuda
            return maximoAyuda(nodo.der);
        }
    }

    public void insertar(T elem){
        raiz = insertarAyuda(raiz,elem);
    }

    public Nodo insertarAyuda(Nodo raiz,T elem){
        if(raiz==null){
            cardinal++;
            raiz = new Nodo(elem);
            return raiz;
        }else if(elem.compareTo(raiz.valor)<0){ // elem menor que raiz
            raiz.izq = insertarAyuda(raiz.izq, elem); // se muevo en el subarbol izq 
        }else if(elem.compareTo(raiz.valor)>0){ // elem meyor que raiz
            raiz.der = insertarAyuda(raiz.der,elem);
        }
        return raiz;
    }

    public boolean pertenece(T elem){
        if(raiz==null){
            return false;  // Caso base: el árbol está vacío, el elemento no puede estar
        }else if(raiz.valor.compareTo(elem)==0){
            return true; // Caso base: el valor en la raíz coincide con el elemento buscado
        }else{
            if(raiz.valor.compareTo(elem)>0){
                 // Si elem es menor que el valor en la raíz, buscamos en el subárbol izquierdo
                ABB<T> arbolIzquierdo = new ABB<>(raiz.izq);
                return arbolIzquierdo.pertenece(elem);
            }else{
                // Si elem es mayor que el valor en la raíz, buscamos en el subárbol derecho
                ABB<T> arbolDerecho = new ABB<>(raiz.der);
                return arbolDerecho.pertenece(elem);
            }
        }
    }

    public void eliminar(T elem){
        raiz = eliminarAyuda(raiz,elem);
    }

    public Nodo eliminarAyuda(Nodo raiz,T elem){
        if(raiz == null){
            return raiz; // si el árbol está vacío, no hay nada que eliminar
        }
        // Si el elemento a eliminar es menor que el valor en la raíz, lo buscamos en el subárbol izquierdo
        if(elem.compareTo(raiz.valor)<0){
            raiz.izq = eliminarAyuda(raiz.izq, elem);
        // Si el elemento a eliminar es mayor que el valor en la raíz, lo buscamos en el subárbol derecho
        }else if(elem.compareTo(raiz.valor)>0){
            raiz.der = eliminarAyuda(raiz.der, elem);
        }else{ // Si encontramos el nodo que contiene el elemento a eliminar:
            // Caso 1: el nodo no tiene hijo izquierdo → se reemplaza por su hijo derecho
            if(raiz.izq==null){
                cardinal--;
                return raiz.der;
            // Caso 2: el nodo no tiene hijo derecho → se reemplaza por su hijo izquierdo
            }else if(raiz.der==null){
                cardinal--;
                return raiz.izq;
            // Caso 3: el nodo tiene dos hijos
            }else{
                // Se busca el valor mínimo en el subárbol derecho (sucesor inorden) yse asigna como raiz 
                raiz.valor=minimoAyuda(raiz.der);
                // Se elimina recursivamente el nodo que contenía ese valor mínimo 
                raiz.der=eliminarAyuda(raiz.der, raiz.valor);
                // El cardinal se decrementa en la llamada recursiva correspondiente
            }
        }
        // Se devuelve la raíz (posiblemente modificada)
        return raiz;
    }

    public String toString(){
        Iterador<T> iterador = new ABB_Iterador();
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        while(iterador.haySiguiente()){
            buffer.append(iterador.siguiente());
            if(iterador.haySiguiente()){
                buffer.append(",");
            }
        }
        buffer.append("}");
        return buffer.toString();
    }


    private class ABB_Iterador implements Iterador<T> {
        private Stack<Nodo> stack;

        public ABB_Iterador(){
            stack = new Stack<Nodo>();
            aLaIzquierda(raiz);
        }

        public boolean haySiguiente() {            
            return !stack.isEmpty();
        }
    
        public T siguiente() {
            if(!haySiguiente()){
                throw new java.util.EmptyStackException();
            }else{
                Nodo raiz = stack.pop();
                aLaIzquierda(raiz.der);
                return raiz.valor;
            }
        }

        private void aLaIzquierda(Nodo nodo){
            while(nodo!=null){
                stack.push(nodo);
                nodo = nodo.izq;
            }
        }
    }

    public Nodo minimoMasALaIzq(Nodo nodo){
        if(nodo.izq==null){
            return nodo;
        }else{
            return minimoMasALaIzq(nodo.izq);
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}


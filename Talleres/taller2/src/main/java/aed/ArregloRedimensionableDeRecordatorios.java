package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] secuenciaRecordatorios; // Este es un arreglo privado que almacena los objetos Recordatorio.
    // Inicialmente, está vacío, pero se redimensiona cuando se agregan o quitan elementos.


    public ArregloRedimensionableDeRecordatorios() {  //El constructor inicializa el arreglo secuenciaRecordatorios con un tamaño de 0, es decir, no contiene elementos al principio.
        this.secuenciaRecordatorios = new Recordatorio[0];
    }
    

    public int longitud() {
        int res = this.secuenciaRecordatorios.length;
        return res;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevaSecuencia = new Recordatorio[this.longitud() + 1]; // creo un arreglo de tamaño mayor(en java los arreglos son tamaño fijo)
        for(int j = 0; j<this.longitud(); j++){
            nuevaSecuencia[j] = this.obtener(j);
        }
        nuevaSecuencia[this.longitud()] = i;
        this.secuenciaRecordatorios = nuevaSecuencia;

    }

    public Recordatorio obtener(int i) {
        return this.secuenciaRecordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevaSecuenciaSinElUltimo = new Recordatorio[this.longitud() - 1];
        for(int j = 0; j<this.longitud() - 1; j++){
            nuevaSecuenciaSinElUltimo[j] = this.obtener(j);
        }
        this.secuenciaRecordatorios = nuevaSecuenciaSinElUltimo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.secuenciaRecordatorios[indice] = valor;
    }

    // ej: constructor copia
    // Tienes un objeto arreglo1 de tipo ArregloRedimensionableDeRecordatorios.
    // Quieres crear un nuevo objeto arreglo2 que sea una copia exacta de arreglo1.
    // Al llamar al constructor de copia, este invoca el método copiar() de arreglo1, lo que da como resultado un nuevo objeto con los mismos elementos que arreglo1.
    // El constructor de copia luego asigna ese nuevo arreglo al nuevo objeto arreglo2.
    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.secuenciaRecordatorios = vector.copiar().secuenciaRecordatorios; // vector.copiar() crea una nueva instancia con los mismos elementos y evita que si uno cambia el otro tambien.
    }
    // La secuencia de recordatorios del objeto recién creado (el que se está construyendo) se asigna a la secuencia de vector copiada.
    // De esta forma, el objeto que se crea como copia es completamente independiente del original, y sus elementos también son copias independientes.

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copiaArreglo = new ArregloRedimensionableDeRecordatorios();
        for(int j = 0; j<this.longitud(); j++){
            copiaArreglo.agregarAtras(this.obtener(j));
        }
        return copiaArreglo;
    // Este método crea una copia profunda del arreglo. Utiliza el método agregarAtras para agregar los 
    // elementos de secuenciaRecordatorios a un nuevo arreglo. Esto asegura que los cambios en el arreglo original 
    // no afecten a la copia.
    }
}

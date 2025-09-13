package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] arregloDeRecordatorios;


    public ArregloRedimensionableDeRecordatorios() {
        arregloDeRecordatorios = new Recordatorio[0];

    }

    public int longitud() {
        return arregloDeRecordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevoArreglo = new Recordatorio[arregloDeRecordatorios.length + 1];
        for (int j = 0; j < arregloDeRecordatorios.length; j++) {
            nuevoArreglo[j] = arregloDeRecordatorios[j]; 
        }
        nuevoArreglo[nuevoArreglo.length - 1] = i;
        this.arregloDeRecordatorios = nuevoArreglo;
    }

    public Recordatorio obtener(int i) {
        return this.arregloDeRecordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevoArreglo = new Recordatorio[arregloDeRecordatorios.length - 1];
        for (int j = 0; j < arregloDeRecordatorios.length - 1 ; j++) {
            nuevoArreglo[j] = arregloDeRecordatorios[j]; 
        }
        this.arregloDeRecordatorios = nuevoArreglo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arregloDeRecordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.arregloDeRecordatorios = vector.copiar().arregloDeRecordatorios;
    }



    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copiaArreglo = new ArregloRedimensionableDeRecordatorios();
        for(int j = 0; j<this.longitud(); j++){
            copiaArreglo.agregarAtras(this.obtener(j));
        }
        return copiaArreglo;
    }
}


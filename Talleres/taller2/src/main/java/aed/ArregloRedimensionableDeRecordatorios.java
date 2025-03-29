package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] secuenciaRecordatorios;


    public ArregloRedimensionableDeRecordatorios() {
        this.secuenciaRecordatorios = new Recordatorio[0];
    }

    public int longitud() {
        int res = this.secuenciaRecordatorios.length;
        return res;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevaSecuencia = new Recordatorio[this.longitud() + 1];
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

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.secuenciaRecordatorios = vector.copiar().secuenciaRecordatorios;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copiaArreglo = new ArregloRedimensionableDeRecordatorios();
        for(int j = 0; j<this.longitud(); j++){
            copiaArreglo.agregarAtras(this.obtener(j));
        }
        return copiaArreglo;

    }
}

package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios = new ArregloRedimensionableDeRecordatorios();
    // recordatorios: Es un objeto de tipo ArregloRedimensionableDeRecordatorios, que es un arreglo dinámico de recordatorios. Es utilizado para almacenar los recordatorios que se agregarán a la agenda.

    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual); 
        // this.fechaActual = new Fecha(fechaActual);: Crea una copia de la fecha proporcionada (para evitar modificar la fecha original fuera de la clase Agenda).
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio); 
    }

  @Override
    public String toString() {
        StringBuffer nuevo = new StringBuffer();
        nuevo.append(this.fechaActual).append("\n").append("=====\n");
        for(int i=0; i<recordatorios.longitud();i++){
            if(this.fechaActual.equals(recordatorios.obtener(i).fecha())){
                nuevo.append(this.recordatorios.obtener(i)).append("\n");
            }
        }
        return nuevo.toString();

    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(fechaActual);
        // Este método devuelve una copia de la fecha actual de la agenda (evita que se modifique directamente el objeto fechaActual desde fuera de la clase Agenda).
    }

}

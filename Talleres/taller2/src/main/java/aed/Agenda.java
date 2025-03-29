package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios = new ArregloRedimensionableDeRecordatorios();

    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual);
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
    }

}

package aed;

public class Agenda {
    private Fecha f;
    private ArregloRedimensionableDeRecordatorios recordatorios = new ArregloRedimensionableDeRecordatorios();

    public Agenda(Fecha fechaActual) {
        this.f = new Fecha(fechaActual);
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        StringBuffer nuevo = new StringBuffer();
        nuevo.append(this.f).append("\n").append("=====\n");
        for(int i=0; i<recordatorios.longitud();i++){
            if(this.f.equals(recordatorios.obtener(i).fecha())){
                nuevo.append(this.recordatorios.obtener(i)).append("\n");
            }
        }
        return nuevo.toString();  
    }

    public void incrementarDia() {
        this.f.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(f);
    }

}

package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;


    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        Horario res = horario;
        return res;
    }

    public Fecha fecha() {
        return new Fecha(this.fecha);
    }

    public String mensaje() {
        String res = mensaje;
        return res;
    }

    @Override
    public String toString() {
        String res = mensaje + " @ " + fecha + " " + horario;
        return res;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroVacio = (otro == null);
        boolean otraClaseDife = (otro.getClass() != this.getClass());
        if (otroVacio || otraClaseDife){
            return false;
        }
        // casting
        Recordatorio otroRecordatorio = (Recordatorio) otro;
        return iguales1(horario, otroRecordatorio.horario) && iguales2(fecha, otroRecordatorio.fecha);
    }

    public boolean iguales1(Horario algo1, Horario algo2){
        boolean res = true;
        if (algo1 != algo2){
            res = false;
        }
        return res;
    }
    public boolean iguales2(Fecha algo1, Fecha algo2){
        boolean res = true;
        if (algo1 != algo2){
            res = false;
        }
        return res;
    }
}

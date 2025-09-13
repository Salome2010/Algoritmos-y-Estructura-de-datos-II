package aed;

public class Recordatorio {
    private String m;
    private Fecha f;
    private Horario h;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.m = mensaje;
        this.f = new Fecha(fecha);
        this.h = horario;

    }

    public Horario horario() {
        return h;
    }

    public Fecha fecha() {
        Fecha fechaCopiada = new Fecha(this.f);
        return fechaCopiada;
    }

    public String mensaje() {
        // Implementar
        return m;
    }

    @Override
    public String toString() {
        return m + " " + "@" + " " + f + " " + h;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsVacio = (otro == null);
        if (otroEsVacio){
            return false;
        }
        boolean claseDistinta = otro.getClass() != this.getClass(); // compara la clase del objeto "otra" con la clase del objeto actual
        if (claseDistinta){
            return false;  // si son disitntas devuelbe false pq no tiene sentido comparar dos clases difeentrs (ej: clase Fecha con clase String u otra)
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro; // como las clases son iguales se hace el cast, para convertir a "otra" en fecha
        return h.equals(otroRecordatorio.h) && f.equals(otroRecordatorio.f) && m.equals(otroRecordatorio.m);
        // (a == b)      // puede ser false si distintos objetos en memoria
        // (a.equals(b)); true  (mismo contenido)
        // ahi si usás el equals de String, Fecha y Horario, que compara contenido y no direcciones de memoria.
    }

}

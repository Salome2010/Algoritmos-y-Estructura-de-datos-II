package aed;

public class Recordatorio { // la clase recordatorio esta representada por un mensaje, una fecha y un horario
    private String mensaje;  // atributos privados (para evitar que cambien desde afuera de la clase)
    private Fecha fecha; // una instancia de la clase Fecha
    private Horario horario;


    public Recordatorio(String mensaje, Fecha fecha, Horario horario) { // constructor de la clase, crea el objeto Recordatorio 
        this.mensaje = mensaje; // asigna el valor recibido al atributo mensaje
        this.fecha = new Fecha(fecha); // Crea una nueva instancia de Fecha, copiando la fecha recibida. 
                                       //Esto se hace para evitar que cambios en el objeto fecha original afecten al recordatorio.
        this.horario = horario;
    }

    public Horario horario() {  // Este método devuelve el horario del recordatorio si no es mutable, ya que son privados y se acceden a traves de metodos
        Horario res = horario;
        return res;
    }

    public Fecha fecha() { // Devuelve una nueva instancia de Fecha, protegiendo el objeto original de modificaciones externas.
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
        Recordatorio otroRecordatorio = (Recordatorio) otro; // convierte otro a Recordatorio
        return iguales1(horario, otroRecordatorio.horario) && iguales2(fecha, otroRecordatorio.fecha);
    }
    // Esto garantiza que equals se use correctamente, verificando el contenido de los objetos en vez de sus direcciones de memoria.
    public boolean iguales1(Horario algo1, Horario algo2){
        boolean res = algo1.equals(algo2);
        return res;
    }

    public boolean iguales2(Fecha algo1, Fecha algo2){
        boolean res = algo1.equals(algo2);
        return res;
    }
}

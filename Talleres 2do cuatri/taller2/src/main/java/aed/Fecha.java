package aed;

public class Fecha {
    private int day;
    private int month;

    public Fecha(int dia, int mes) { //  constructor que inicializa una instancia/s de la clase (objeto/s)
        this.day = dia;
        this.month = mes;

    }

    public Fecha(Fecha fecha) { 
        this.day = fecha.day;
        this.month = fecha.month;
    }

    public Integer dia() {
        return day;
    }

    public Integer mes() {
        return month;
    }

    public String toString() {
        return day + "/" + month;
    }

    @Override
    public boolean equals(Object otra) {
        boolean otraEsVacio = (otra == null);
        if (otraEsVacio){
            return false;
        }
        boolean claseDistinta = otra.getClass() != this.getClass(); // compara la clase del objeto "otra" con la clase del objeto actual
        if (claseDistinta){
            return false;  // si son disitntas devuelbe false pq no tiene sentido comparar dos clases difeentrs (ej: clase Fecha con clase String u otra)
        }
        Fecha otraFecha = (Fecha) otra; // como las clases son iguales se hace el cast, para convertir a "otra" en fecha
        return day == otraFecha.day && month == otraFecha.month;

    }

    public void incrementarDia() {
        if(diasEnMes(this.month) == this.day && this.month != 12){
            this.day = 1;
            this.month = month + 1;
        } else if (this.month == 12){
            this.day = 1;
            this.month = 1;
        } else{
            this.day = day + 1;
            this.month = month;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}

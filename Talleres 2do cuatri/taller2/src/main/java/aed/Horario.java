package aed;

public class Horario {
    private int h;
    private int m;

    public Horario(int hora, int minutos) {
        this.h = hora;
        this.m = minutos;
    }

    public int hora() {
        return h;
    }

    public int minutos() {
        return m;
    }

    @Override
    public String toString() {
        return h + ":" + m;
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
        Horario otroHorario = (Horario) otro; // como las clases son iguales se hace el cast, para convertir a "otra" en fecha
        return h == otroHorario.h && m == otroHorario.m;
    }

}

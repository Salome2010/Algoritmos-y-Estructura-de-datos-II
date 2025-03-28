package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos  = minutos;
    }

    public int hora() {
        int res = hora;
        return res; 
    }

    public int minutos() {
        int res = minutos;
        return res;
    }

    @Override
    public String toString() {
        String res = hora + ":"+ minutos;
        return res;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroNull = (otro == null);
        boolean otraClaseDif = (otro.getClass() != this.getClass());
        if (otroNull || otraClaseDif){
            return false;
        }
        // casting
        Horario otroHora = (Horario) otro;
        return horariosIguales(hora, otroHora.hora) && horariosIguales(minutos, otroHora.minutos);
    }

    public boolean horariosIguales(int algo1,int algo2){
        boolean res = true;
        if (algo1 != algo2){
            res = false;
        }
        return res;
    }

}

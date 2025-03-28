package aed;

public class Fecha {
    private int dia;
    private int mes;


    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;

    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;

    }

    public Integer dia() {
        int res = dia;
        return res;
    }

    public Integer mes() {
        int res = mes;
        return res;
    }

    public String toString() {
        String res = dia + "/" + mes;
        return res;
    }

    @Override
    public boolean equals(Object otra) {
        boolean otraEsNull = (otra == null);
        boolean otraClaseDistinta = otra.getClass() != this.getClass();
        if (otraEsNull || otraClaseDistinta){
            return false;
        }
        // casting
        Fecha otraFecha = (Fecha) otra;
        return fechasIguales(dia, otraFecha.dia) && fechasIguales(mes, otraFecha.mes);
    }

    public boolean fechasIguales(int algo1, int algo2){
        boolean res = true;
        if (algo1 != algo2){
            res = false;
        }
        return res;
    }

    public void incrementarDia() {

        if ((diasEnMes(this.mes) == this.dia && this.dia == 28) || (diasEnMes(this.mes) == this.dia && this.dia == 30)){
            this.dia = 1;
            this.mes = this.mes + 1;
        } else if (diasEnMes(this.mes) == this.dia && this.dia==31 && this.mes ==12){
            this.dia = 1;
            this.mes = 1;
        }else{
            this.dia = this.dia + 1;
            this.mes = this.mes;
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

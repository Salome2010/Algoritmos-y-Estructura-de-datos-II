package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x*x + y*y);
    }

    boolean divideA(int d, int n) {
        boolean res = false;
        if ((n%d)==0){
            res = true;
        }
        return res;
    }

    boolean esPar(int n) {
        boolean res = false;
        if ((n==0) || divideA(2,n)){
            res = true;
        }
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res = false;
        if (divideA(4,n) && (!divideA(100, n))){
            res = true;
        } else if(divideA(400, n)){
            res = true;
        }
        return res;
    }

    int factorialIterativo(int n) {
        int factorial = 1;
        for (int i=1; i<=n; i++){
            factorial = factorial * i;
        }
        return factorial;
    }

    int factorialRecursivo(int n) {
        int factorialR = 1;
        if(n>0){
            factorialR = n * factorialRecursivo(n-1);
        }
        return factorialR;
    }

    boolean esPrimo(int n) {
        boolean res = true;
        if (n<=1) {
            res = false;
        } else if (n==2 || n==3 || n==5 || n==7){
            res = true;
        } else if (divideA(2, n) ||divideA(3, n) || divideA(5, n) || divideA(7, n)){
            res = false;
        }
        return res;
    }

    int sumatoria(int[] numeros) {
        int suma = 0;
        for(int i=0; i<numeros.length; i++){
            suma+= numeros[i];
        }
        return suma;
    }

    int busqueda(int[] numeros, int buscado) {
        int indice = 0;
        for(int i=0; i<numeros.length; i++){
            if (numeros[i] == buscado){
                indice = i;
            }
        }
        return indice;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for(int i=0; i<numeros.length; i++){
            if (esPrimo(numeros[i])){
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for(int i =0; i<numeros.length; i++){
            if (!(divideA(2,numeros[i]))){
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        int j = s2.length();
        int m = s1.length();
        for(int i=0; i < m; i++){
            if ( m>j || (s1.charAt(i)) != (s2.charAt(i)) ){
                res = false;
            } 
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = true;
        int j = s2.length();
        int m = s1.length();
        String s1DadoVuelta = "";
        String s2DadoVuelta = "";
        for (int i=0; i<m; i++){
            s1DadoVuelta+= s1.charAt(m - i -1);
        }
        for (int k=0; k<j; k++){
            s2DadoVuelta+= s2.charAt(j - k -1);
        }
        if (s1DadoVuelta.length() > s2DadoVuelta.length()){
            res = false;
        } else if (!esPrefijo(s1DadoVuelta, s2DadoVuelta)){
            res = false;
        }
        return res;
    }
}

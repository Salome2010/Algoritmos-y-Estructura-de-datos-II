package aed;

class Funciones {

/***  Primera parte: Funciones en java ***/

    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x*x + y*y);
    }

    boolean divideA(int d, int n){
        boolean res = false;
        if (n%d==0){
            res = true;
        }
        return res;
    }

    boolean esPar(int n) {
        boolean res = false;
        if (divideA(2, n)){
            res = true;
        }
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res = false;
        if ((divideA(4,n) && (!divideA(100, n))) || (divideA(400, n))){
            res = true;
        }
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i<=n; i++) {
            res = res*i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int resRecu = 1;
        if (n>0){
            resRecu = n * factorialRecursivo(n-1);
        }
        return resRecu;
    }

    boolean esPrimo(int n) {
        boolean res = true;
        if (n<2) {
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
        for (int i = 0; i < numeros.length; i++) {
            suma = suma + numeros[i];
        }
        return suma;
    }

    int busqueda(int[] numeros, int buscado) {
        int indice = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado){
                indice = i;
            }
        }
        return indice;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])){
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int i = 0; i < numeros.length; i++) {
            if (!esPar(numeros[i])){
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        int j = s1.length();
        int k = s2.length();
        for (int i = 0; i < j; i++) {
            if (j > k|| (s1.charAt(i) != s2.charAt(i))){
                res = false;
            }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = true;
        String s1R = "";
        String s2R = "";
        for (int i = 0; i < s1.length(); i++) {
            s1R += s1.charAt(s1.length() - i -1);
        }
        for (int i = 0; i < s2.length(); i++) {
            s2R += s2.charAt(s2.length() - i -1);
        }
        for (int i = 0; i < s1R.length(); i++) {
            if (s1R.length() > s2R.length() || !esPrefijo(s1R, s2R)){
                res = false;
            }
            
        }
        return res;
    }

/***  Segunda parte: Debugging ***/

    boolean xor(boolean a, boolean b) {
        return ((a && !b) || (!a && b));
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;
        int j = xs.length;
        int m = ys.length;
        for (int i = 0; i < j; i++) {
            if (j>m || m>j || xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        if (xs.length <= 1){
            return res;
        }
        for (int i = 0; i < xs.length-1; i++) {
            if (xs[i+1] < xs [i]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = xs[0];
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] >= res) res = xs[i];
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int x : xs) {
            if (x <= 0) {
                res = false;
            }
        }
        return res;
    }

}

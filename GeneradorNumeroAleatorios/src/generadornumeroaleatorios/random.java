package generadornumeroaleatorios;

/*
///////////////////////MANUAL RAPIDO DE USUARIO /////////////////////////////////////////////////////////////////////////////////////////////////////

Hay dos maneras de generar los numeros aleatorios:
        1-En grupo: Cuando se crea el objeto poner la semilla y la cantidad de numeros que se quiere generar.
        2-Individual: Cuando se crea el objeto solo se pone la semilla

Hay dos tipos de numeros aleatorios que se pueden generar directamente.
    1- U[0,1]
    2- Enteros

        Para generar por grupo: se TIENE que llemar al metodo ---- generar() ----
            Para imprimirlo de U[0,1]: se llama  ---- print_random_numbers() ----
                Para acotarlos y mostrarlos: se llama ---- print_random_numbers_acotados(int desde)(int hasta) ----
            Para imprimir Enteros: se llama  ---- print_int_random_numbers() ----
                Para acotarlos y mostrarlo: Se llama ---- print_int_random_numbers_acotados(int desde,int hasta) ----



Cuando se generan de manera individual se recomientda utilizar un ciclo -for- para imprimirlos.
Estos se pueden acotar:
    Para acotar enteros se utiliza   ---- nextIntAcotado(int desde,int hasta) ----
    Para acotar no entero se utiliza ---- nextAcotado (double desde, double hasta) ----





/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 */
public class random {

    public double[] randomNum; //Aqui se guardan "U[0,1]" numeros pseudo aleatorios 
    public int[] intRandomNum; //Aqui se guardan los numeros enterospseudo aleatorios

    private final static int a = 25173;
    private final static int c = 13849;
    private final static int m = 32768;  //2147483647
    

    private int zi;

    public random(int semilla, int cuantos) {
        this.randomNum = new double[cuantos];
        this.intRandomNum = new int[cuantos];
        this.zi = semilla;
    }

    public random(int semilla) {
        this.zi = semilla;
    }

    public double next() {
        zi = (a * zi + c) % m;
        return (double) zi / m;
    }

    public double nextAcotado(double desde, double hasta) {
        double eleatorio = 0;
        eleatorio = next() * (hasta - desde + 1) + desde;
        if (eleatorio > hasta) {
            eleatorio = hasta;
        }

        return eleatorio;
    }

    public int nextIntAcotado(int desde, int hasta) {
        int eleatorio = 0;

        eleatorio = (int) Math.round((next() * (hasta - desde + 1) + desde));
        if (eleatorio > hasta) {
            eleatorio = hasta;
        }
        return eleatorio;
    }

    public int nextInt() {
        zi = (a * zi + c) % m;

        return zi;

    }

    public void generar() {
        for (int i = 0; i < intRandomNum.length; i++) {
            zi = (a * zi + c) % m;
            intRandomNum[i] = zi;
        }
        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = ((double) intRandomNum[i]) / ((double) m);
        }

    }

    public void print_random_numbers() {

        for (int i = 0; i < randomNum.length; i++) {
            System.out.println(randomNum[i]);
        }
    }

    public void print_random_numbers_acotados(int desde, int hasta) {
        for (int i = 0; i < randomNum.length; i++) {
            System.out.println(randomNum[i] * (hasta - desde + 1) + desde);
        }

    }

    public void print_int_random_numbers_acotados(int desde, int hasta) {

        int eleatorio = 0;

        for (int i = 0; i < randomNum.length; i++) {
            eleatorio = (int) Math.round((randomNum[i] * (hasta - desde + 1) + desde));
            if (eleatorio == 11) {
                System.out.println(10);
            } else {
                System.out.println(eleatorio);
            }
        }
    }

    public void print_int_random_numbers() {

        for (int i = 0; i < intRandomNum.length; i++) {
            System.out.println(intRandomNum[i]);
        }
    }

}

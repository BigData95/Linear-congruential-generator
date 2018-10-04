/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadornumeroaleatorios;

/**
 *
 * @author Ivan
 */
public class random {

    public double[] random_numbers; //contains "U[0,1]"-pseudo-random numbers
    public int[] int_random_numbers; //contains the sequence of integer random numbers

    // Linear congruential values for x(i+1) = (a * x(i) + b) % m.
    final static int a = 25173;
    final static int c = 13849;
    final static int m = 32768;

    // Current value for returning.
    int zi;

    public random(int semilla, int cuantos) {
        this.random_numbers = new double[cuantos];
        this.int_random_numbers = new int[cuantos];
        this.zi = semilla;
    }

    public random(int semilla) {
        this.zi = semilla;
    }

    double next() {
        // Calculate next value in sequence.
        zi = (a * zi + c) % m;

        // Return its 0-to-1 value.
        return (double) zi / m;
    }

    double nextAcotado(double desde, double hasta) {
        double eleatorio = 0;
        eleatorio = next() * (hasta - desde + 1) + desde;
        if (eleatorio > hasta) {
            eleatorio = hasta;
        }
        
        return eleatorio;
    }

    int nextIntAcotado(int desde, int hasta) {
        int eleatorio = 0;

        eleatorio = (int) Math.round((next() * (hasta - desde + 1) + desde));
        if (eleatorio > hasta) {
            eleatorio = hasta;
        }
        return eleatorio;
    }

    int nextInt() {
        zi = (a * zi + c) % m;

        return zi;

    }

    public void generar() {
        for (int i = 0; i < int_random_numbers.length; i++) {
            zi = (a * zi + c) % m;
            int_random_numbers[i] = zi;
        }
        for (int i = 0; i < random_numbers.length; i++) {
            random_numbers[i] = ((double) int_random_numbers[i]) / ((double) m);
        }

    }

    public void print_random_numbers() {

        for (int i = 0; i < random_numbers.length; i++) {
            System.out.println(random_numbers[i]);
        }
    }

    public void print_random_numbers_acotados(int desde, int hasta) {
        for (int i = 0; i < random_numbers.length; i++) {
            System.out.println(random_numbers[i] * (hasta - desde + 1) + desde);
        }

    }

    public void print_int_random_numbers_acotados(int desde, int hasta) {

        int eleatorio = 0;

        for (int i = 0; i < random_numbers.length; i++) {
            eleatorio = (int) Math.round((random_numbers[i] * (hasta - desde + 1) + desde));
            if (eleatorio == 11) {
                System.out.println(10);
            } else {
                System.out.println(eleatorio);
            }
        }
    }

    public void print_int_random_numbers() {

        for (int i = 0; i < int_random_numbers.length; i++) {
            System.out.println(int_random_numbers[i]);
        }
    }

}

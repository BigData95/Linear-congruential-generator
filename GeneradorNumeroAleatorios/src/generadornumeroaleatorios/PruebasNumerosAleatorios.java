/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadornumeroaleatorios;

import java.util.Arrays;
import java.util.function.BiFunction;

public class PruebasNumerosAleatorios {

    private int semilla;
    private int numSol;   // n en parametros
    double mejorSolucion[];
    double[] solucionDimenciones;
    int dimension;

    public PruebasNumerosAleatorios(int semilla, int numSol, int dimension) {
        this.semilla = semilla;
        this.numSol = numSol;
        this.dimension = dimension;
        mejorSolucion = new double[dimension];
        Arrays.fill(mejorSolucion, 10000000000000000000000.00);
        solucionDimenciones = new double[dimension];
    }

    public void prueba(String prueba) {
        random rd1 = new random(semilla);

        for (int i = 0; i < numSol; i++) {
            for (int j = 0; j < dimension; j++) {
                switch (prueba) {
                    case "schwefelUnimodal":
                        solucionDimenciones[j] = schwefelUnimodal(numSol, rd1.nextIntAcotado(-10, 10));
                        break;
                    case "schwefelMultimodal":
                        solucionDimenciones[j] = schwefelMultimodal(numSol, rd1.nextIntAcotado(-500, 500));
                        break;
                    case "rosenbrock":
                        solucionDimenciones[j] = rosenbrock(numSol, rd1.nextIntAcotado(-30, 30), rd1.nextIntAcotado(-30, 30));
                        break;
                    case "paso":
                        solucionDimenciones[j] = paso(numSol, rd1.nextIntAcotado(-100, 100));
                        break;
                    case "rastrigin":
                        solucionDimenciones[j] = rastrigin(numSol, rd1.nextAcotado(-5.12, 5.12));
                        break;
                    case "ackley":
                        solucionDimenciones[j] = ackley(numSol, rd1.nextIntAcotado(-32, 32));
                        break;
                    case "griewank":
                        solucionDimenciones[j] = griewank(numSol, rd1.nextIntAcotado(-600, 600));
                        break;

                }
            }
        }
        for (int i = 0; i < dimension; i++) {
            if (solucionDimenciones[i] < mejorSolucion[i]) {
                mejorSolucion[i] = solucionDimenciones[i];
            }
        }

    }

    public double[] getMejorSolucion() {
        return mejorSolucion;
    }

    public double[] getSolucionPruba() {
        return solucionDimenciones;
    }

    private double schwefelUnimodal(int n, int x1) {
        double suma = 0;
        for (int i = 0; i < n; ++i) {
            suma += Math.pow(x1, 2) * Math.abs(x1);
        }
        return suma;
    }

    private double schwefelMultimodal(int n, int x1) {
        double suma = 0;
        for (int i = 0; i < n; i++) {
            suma += x1 * Math.sin(Math.sqrt(Math.abs(x1)));
        }
        return 418.9829 - suma;
    }

    private double rosenbrock(int n, int x1, int x2) {
        double suma = 0;
        for (int i = 0; i < n; i++) {
            suma += 100 * (x2 - Math.pow(x1, 2)) + (Math.pow(x1 - 1, 2));
            x1 = x2;
        }
        return suma;
    }

    private double paso(int n, int x1) {
        double suma = 0;
        for (int i = 0; i < n; i++) {
            suma += Math.pow(Math.floor(x1 + .5), 2);

        }
        return suma;
    }

    private double rastrigin(int n, double x1) {
        double suma = 0;
        for (int i = 0; i < n; i++) {
            suma += Math.pow(x1, 2) - 10 * Math.cos(2 * Math.PI * x1) + 10;
        }
        return suma;
    }

    private double ackley(int n, int x1) {
        double suma1 = 0;
        double suma2 = 0;
        for (int i = 0; i < n; i++) {
            suma1 += Math.exp(n);
            suma2 += Math.cos((2 * Math.PI) * x1);
        }
        return -20 * (Math.exp(-0.2) * (Math.sqrt((1 / n) * suma1)) - (Math.exp((1 / n)) * suma2 + 20 + Math.exp(1)));
    }

    private double griewank(int n, int x1) {
        double suma = 0;
        double multiplicacion = 1;

        for (int i = 0; i < n; i++) {
            suma += Math.pow(x1, 2);
            multiplicacion *= Math.cos((x1 / Math.sqrt(i))) + 1;
        }
        return (1 / 400) * suma - multiplicacion;
    }

}

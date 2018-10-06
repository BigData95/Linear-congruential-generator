/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadornumeroaleatorios;

import java.math.BigDecimal;
import java.util.Arrays;

public class PruebasNumerosAleatorios {

    private int semilla;
    private int numSol;   // n en parametros
    double mejorSolucionGlobal = 100000000000000000000000000.00;
    double mejorSolucionPrueba = 1000000000000000000000000000.00;
    double solucionPrueba = 0;
    int dimension;

    public PruebasNumerosAleatorios(int semilla, int numSol, int dimension) {
        this.semilla = semilla;
        this.numSol = numSol;
        this.dimension = dimension;

    }

    public void prueba(String prueba) {
        random rd1 = new random(semilla);

        for (int i = 0; i < numSol; i++) {
            switch (prueba) {
                case "schwefelUnimodal":
                    solucionPrueba = schwefelUnimodal(rd1.nextAcotado(-10, 10), rd1.nextAcotado(-10, 10), rd1.nextAcotado(-10, 10), rd1.nextAcotado(-10, 10), rd1.nextAcotado(-10, 10));
                    break;
                case "schwefelMultimodal":
                    solucionPrueba = schwefelMultimodal(rd1.nextAcotado(-500, 500), rd1.nextAcotado(-500, 500), rd1.nextAcotado(-500, 500), rd1.nextAcotado(-500, 500), rd1.nextAcotado(-500, 500));
                    break;
                case "rosenbrock":
                    solucionPrueba = rosenbrock(rd1.nextAcotado(-30, 30), rd1.nextAcotado(-30, 30), rd1.nextAcotado(-30, 30), rd1.nextAcotado(-30, 30), rd1.nextAcotado(-30, 30), rd1.nextAcotado(-30, 30));
                    break;
                case "paso":
                    solucionPrueba = paso(rd1.nextAcotado(-100, 100), rd1.nextAcotado(-100, 100), rd1.nextAcotado(-100, 100), rd1.nextAcotado(-100, 100), rd1.nextAcotado(-100, 100));
                    break;
                case "rastrigin":
                    solucionPrueba = rastrigin(rd1.nextAcotado(-5.12, 5.12), rd1.nextAcotado(-5.12, 5.12), rd1.nextAcotado(-5.12, 5.12), rd1.nextAcotado(-5.12, 5.12), rd1.nextAcotado(-5.12, 5.12));
                    break;
                case "ackley":
                    solucionPrueba = ackley(rd1.nextAcotado(-32, 32), rd1.nextAcotado(-32, 32), rd1.nextAcotado(-32, 32), rd1.nextAcotado(-32, 32), rd1.nextAcotado(-32, 32), i + 1);
                    break;
                case "griewank":
                    solucionPrueba = griewank(rd1.nextAcotado(-600, 600), rd1.nextAcotado(-600, 600), rd1.nextAcotado(-600, 600), rd1.nextAcotado(-600, 600), rd1.nextAcotado(-600, 600), i);
                    break;

            }
            if (solucionPrueba < mejorSolucionPrueba) {
                mejorSolucionPrueba = solucionPrueba;
            }

        }
        if (mejorSolucionPrueba < mejorSolucionGlobal) {
            mejorSolucionGlobal = mejorSolucionPrueba;
        }

    }

    public double getMejorSolucion() {
        return mejorSolucionGlobal;
    }

    public double getSolucionPruba() {
        return mejorSolucionPrueba;
    }

    private double schwefelUnimodal(double x1, double x2, double x3, double x4, double x5) {
        double suma = 0;
        double multiplicacion = 1;
        if (dimension == 3) {
            x4 = 0;
            x5 = 0;
            //* Math.abs(x1);
        }
        suma = Math.pow(x1, 2) + Math.pow(x2, 2) + Math.pow(x3, 2) + Math.pow(x4, 2) + Math.pow(x5, 2);
        if (dimension == 3) {
            x4 = 1;
            x5 = 1;
        }
        multiplicacion = Math.abs(x1) * Math.abs(x2) * Math.abs(x3) * Math.abs(x4) * Math.abs(x5);

        return suma * multiplicacion;
    }

    private double schwefelMultimodal(double x1, double x2, double x3, double x4, double x5) {
        double suma = 0;
        if (dimension == 3) {
            x4 = 0;
            x5 = 0;
        }
        suma = (x1 * Math.sin(Math.sqrt(Math.abs(x1)))) + (x2 * Math.sin(Math.sqrt(Math.abs(x1))))
                + (x3 * Math.sin(Math.sqrt(Math.abs(x3)))) + (x4 * Math.sin(Math.sqrt(Math.abs(x4))))
                + (x5 * Math.sin(Math.sqrt(Math.abs(x5))));

        return 418.9829 - suma;
    }

    private double rosenbrock(double x1, double x2, double x3, double x4, double x5, double x6) {
        double suma = 0;
        if (dimension == 3) {
            suma = (100 * (x2 - Math.pow(x1, 2)) + (Math.pow(x1 - 1, 2)))
                    + (100 * (x3 - Math.pow(x1, 2)) + (Math.pow(x2 - 1, 2)))
                    + (100 * (x4 - Math.pow(x1, 2)) + (Math.pow(x3 - 1, 2)));
        } else {
            suma = (100 * (x2 - Math.pow(x1, 2)) + (Math.pow(x1 - 1, 2)))
                    + (100 * (x3 - Math.pow(x1, 2)) + (Math.pow(x2 - 1, 2)))
                    + (100 * (x4 - Math.pow(x1, 2)) + (Math.pow(x3 - 1, 2)))
                    + (100 * (x5 - Math.pow(x1, 2)) + (Math.pow(x4 - 1, 2)))
                    + (100 * (x6 - Math.pow(x1, 2)) + (Math.pow(x5 - 1, 2)));
        }

        return suma;
    }

    private double paso(double x1, double x2, double x3, double x4, double x5) {
        double suma = 0;
        if (dimension == 3) {
            x4 = -0.5;
            x5 = -0.5;
        }
        suma = (Math.pow(Math.floor(x1 + .5), 2)) + (Math.pow(Math.floor(x2 + .5), 2)) + (Math.pow(Math.floor(x3 + .5), 2))
                + (Math.pow(Math.floor(x4 + .5), 2)) + (Math.pow(Math.floor(x5 + .5), 2));

        return suma;
    }

    private double rastrigin(double x1, double x2, double x3, double x4, double x5) {
        double suma = 0;
        if (dimension == 3) {
            x4 = 0;
            x5 = 0;
        }
        suma = (Math.pow(x1, 2) - 10 * Math.cos(2 * Math.PI * x1) + 10) + (Math.pow(x2, 2) - 10 * Math.cos(2 * Math.PI * x2) + 10)
                + (Math.pow(x3, 2) - 10 * Math.cos(2 * Math.PI * x3) + 10) + (Math.pow(x4, 2) - 10 * Math.cos(2 * Math.PI * x4) + 10)
                + (Math.pow(x5, 2) - 10 * Math.cos(2 * Math.PI * x5) + 10);

        return suma;
    }

    private double ackley(double x1, double x2, double x3, double x4, double x5, int i) {
        double suma1 = 0;
        double suma2 = 0;
        if (dimension == 3) {
            x4 = 0;
            x5 = 0;
        }
        suma1 = (Math.pow(x1, i)) + (Math.pow(x2, i)) + (Math.pow(x3, i)) + (Math.pow(x4, i)) + (Math.pow(x5, i));
        if (dimension == 3) {
            x4 = 0.25;
            x5 = 0.25; // cos(2PI * 0.25 ) = 0
        }
        suma2 = (Math.cos((2 * Math.PI) * x1)) + (Math.cos((2 * Math.PI) * x2)) + (Math.cos((2 * Math.PI) * x3))
                + (Math.cos((2 * Math.PI) * x4)) + (Math.cos((2 * Math.PI) * x5));

        return -20 * (Math.exp(-0.2) * (Math.sqrt((1 / i) * suma1)) - (Math.exp((1 / i)) * suma2 + 20 + Math.exp(1)));
    }

    private double griewank(double x1, double x2, double x3, double x4, double x5, int i) {
        double suma = 0;
        double multiplicacion = 1;
        multiplicacion = Math.cos((x1 / Math.sqrt(i))) + 1;
        if (dimension == 3) {
            multiplicacion = (Math.cos((x1 / Math.sqrt(i))) + 1) + (Math.cos((x2 / Math.sqrt(i))) + 1) + (Math.cos((x3 / Math.sqrt(i))) + 1);
            x4 = 0;
            x5 = 0;
        }
        multiplicacion = (Math.cos((x1 / Math.sqrt(i))) + 1) + (Math.cos((x2 / Math.sqrt(i))) + 1) + (Math.cos((x3 / Math.sqrt(i))) + 1)
                + (Math.cos((x4 / Math.sqrt(i))) + 1) + (Math.cos((x5
                / Math.sqrt(i))) + 1);
        suma = (Math.pow(x1, 2)) + (Math.pow(x2, 2)) + (Math.pow(x3, 2)) + (Math.pow(x4, 2)) + (Math.pow(x5, 2));

        return (1 / 400) * suma - multiplicacion;
    }
}

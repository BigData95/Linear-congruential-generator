package generadornumeroaleatorios;

import java.util.Arrays;

/*
 ===================================================================================================
 Name        : Tarea 2 Heuristicas 
 Author      : Edgar Ivan Martinez Vargas
 Version     : 1.0
 Copyright   : 
 Description : Es es la clase principal que ejecuta y resuelve los problemas 2 y 3 de la tarea 2.
 ==================================================================================================
 */
public class GeneradorNumeroAleatorios {

    public static void main(String[] args) {
        GeneradorNumeroAleatorios app = new GeneradorNumeroAleatorios();
        //app.iniciaAleatorio();
        app.pruebaAleatorio();
    }

    public void iniciaAleatorio() {
        random rd = new random(50, 500);

        rd.generar();
        rd.print_random_numbers();      //Imprime numeros aleatorios entre o y 1
        rd.print_int_random_numbers_acotados(0, 500);  //Imprime numeros aleatorios acotados entre 0 y 500

    }

    public void pruebaAleatorio() {
        PruebasNumerosAleatorios pruebaDimension = new PruebasNumerosAleatorios(50, 10, 5);

        pruebaDimension.prueba("schwefelUnimodal");
        System.out.println("Solucion Prueba Schwefel Unimodal: " +(pruebaDimension.getSolucionPruba()));

        pruebaDimension.prueba("rosenbrock");
        System.out.println("Solucion prueba Rosenbrock:  " +(pruebaDimension.getSolucionPruba()));

        pruebaDimension.prueba("paso");
        System.out.println("Solucion prueba Paso: " + (pruebaDimension.getSolucionPruba()));

        pruebaDimension.prueba("schwefelMultimodal");
        System.out.println("Solucion prueba Schwefel Multimodal: " +(pruebaDimension.getSolucionPruba()));

        pruebaDimension.prueba("rastrigin");
        System.out.println("Solucion prueba Rastrigin: " + (pruebaDimension.getSolucionPruba()));

        pruebaDimension.prueba("ackley");
        System.out.println("Solucion prueba Ackley: " + (pruebaDimension.getSolucionPruba()));

        pruebaDimension.prueba("griewank");
        System.out.println("Solucion prueba Griewank: " + (pruebaDimension.getSolucionPruba()));

        
        System.out.println("Mejor Solucion");
        System.out.println((pruebaDimension.mejorSolucionGlobal));
    }
}

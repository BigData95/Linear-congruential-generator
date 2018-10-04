/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadornumeroaleatorios;

import java.util.Arrays;

/**
 *
 * @author Ivan
 */
public class GeneradorNumeroAleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorNumeroAleatorios app = new GeneradorNumeroAleatorios();
        app.iniciaAleatorio();
    }

    public void iniciaAleatorio() {
        random rd = new random(50, 50);;
       // System.out.println("Prueba del segundo");

        //Dos maneras de generarlos////Esta es 1 a 1.
//        for (int i = 0; i <= 500; i++) {
//
//            System.out.println(rd.nextAcotado(-10, 10));
//
//        }
        ///Utilizando como Javan Random
//      for(int i=0; i<=50;i++){
//            System.out.println(Math.floor(rd.next()*6 + 1) );   //Numeros generados del 0 al 6 
//        }
//        

        //rd.generar();
        //rd.print_random_numbers();
        PruebasNumerosAleatorios pruebaDimension3 = new PruebasNumerosAleatorios(50, 10, 3);
        pruebaDimension3.prueba("schwefelMultimodal");
        System.out.println(Arrays.toString(pruebaDimension3.getSolucionPruba()));
        System.out.println(Arrays.toString(pruebaDimension3.getMejorSolucion()));

        //System.out.println("enteros");
        //rd.print_int_random_numbers_acotados(-10, 10);
        //rd.print_int_random_numbers();
    }
}

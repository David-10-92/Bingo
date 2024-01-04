package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CartonTest {

        GenereadorNumeros genereadorNumeros = new GenereadorNumeros() {
            private int[] numeros = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            private int posicion = 0;
            @Override
            public int generarNumeros() {
                return numeros[posicion++];
            }
        };

    Carton carton = new Carton(genereadorNumeros);

    @Test
    void testNoTacha(){
        carton.tachar(1);
        EstadoPartida estadoIniciada = carton.tachar(2);
        Assertions.assertEquals(EstadoPartida.INICIADA,estadoIniciada);
    }

    @Test
    void testTachaLinea(){
        carton.tachar(1);
        carton.tachar(2);
        carton.tachar(3);
        carton.tachar(4);
        EstadoPartida estadoLinea = carton.tachar(5);
        Assertions.assertEquals(EstadoPartida.LINEA,estadoLinea);
    }
    @Test
    void testTachaBingo(){
        carton.tachar(1);
        carton.tachar(2);
        carton.tachar(3);
        carton.tachar(4);
        carton.tachar(5);
        carton.tachar(6);
        carton.tachar(7);
        carton.tachar(8);
        carton.tachar(9);
        carton.tachar(10);
        carton.tachar(11);
        carton.tachar(12);
        carton.tachar(13);
        carton.tachar(14);
        EstadoPartida estadoBingo = carton.tachar(15);
        Assertions.assertEquals(EstadoPartida.BINGO,estadoBingo);
    }

}

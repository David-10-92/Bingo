package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartidaTest {

    private Carton crearCarton(int... numeros){
        GeneradorNumeroTest generarNumeros = new GeneradorNumeroTest(numeros);
        return new Carton(generarNumeros);
    }
    @Test
    void MismoJugadorCantaBingoYLineaConUnCarton(){
        int[] numeros = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        GeneradorNumeroTest generar = new GeneradorNumeroTest(numeros);
        IBombo bombo = new Bombo(generar);

        List<IJugador> jugadores = Arrays.asList(
                new Jugador("David",Arrays.asList(crearCarton(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15))),
                new Jugador("Mariano",Arrays.asList(crearCarton(1,50,3,4,60,6,7,80,9,10,21,12,26,14,28))),
                new Jugador("Gema",Arrays.asList(crearCarton(1,20,30,4,50,60,7,8,90,10,31,52,13,64,15))),
                new Jugador("Jose",Arrays.asList(crearCarton(1,22,32,42,52,62,72,82,90,40,41,42,43,44,55))),
                new Jugador("Angel",Arrays.asList(crearCarton(1,25,35,45,55,65,75,85,9,50,51,52,53,54,55)))
        );

        Partida partida = new Partida(jugadores,bombo);
        Map<EstadoPartida,IJugador> jugadorGandor = partida.jugar();
        Assertions.assertEquals("David", jugadorGandor.get(EstadoPartida.LINEA).getNombre());
        Assertions.assertEquals("David", jugadorGandor.get(EstadoPartida.BINGO).getNombre());
    }

    @Test
    void DistintosJugadoresCantanBingoYLineaConDosCartones(){
        int[] numeros = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        GeneradorNumeroTest generar = new GeneradorNumeroTest(numeros);
        IBombo bombo = new Bombo(generar);

        List<IJugador> jugadores = Arrays.asList(
                new Jugador("David",Arrays.asList(crearCarton(1,10,30,4,50,6,7,80,15,2,21,12,13,14,9),crearCarton(1,10,3,4,5,6,7,8,15,2,11,12,13,14,9))),
                new Jugador("Mariano",Arrays.asList(crearCarton(1,2,3,4,5,6,7,80,9,10,21,12,26,14,28),crearCarton(1,22,32,42,52,62,72,82,90,40,41,42,43,44,55))),
                new Jugador("Gema",Arrays.asList(crearCarton(1,20,30,4,50,60,7,8,90,10,31,52,13,64,15),crearCarton(1,22,32,42,52,62,72,82,90,40,41,42,43,44,55))),
                new Jugador("Jose",Arrays.asList(crearCarton(1,22,32,42,52,62,72,82,90,40,41,42,43,44,55),crearCarton(1,22,32,42,52,62,72,82,90,40,41,42,43,44,55))),
                new Jugador("Angel",Arrays.asList(crearCarton(1,25,35,45,55,65,75,85,9,50,51,52,53,54,55),crearCarton(1,22,32,42,52,62,72,82,90,40,41,42,43,44,55)))
        );

        Partida partida = new Partida(jugadores,bombo);
        Map<EstadoPartida,IJugador> jugadorGandor = partida.jugar();
        Assertions.assertEquals("Mariano", jugadorGandor.get(EstadoPartida.LINEA).getNombre());
        Assertions.assertEquals("David", jugadorGandor.get(EstadoPartida.BINGO).getNombre());
    }
}


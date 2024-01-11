package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class JugadorTest {

    int [] numero = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    GeneradorNumeroTest generar = new GeneradorNumeroTest(numero);
    Carton carton = new Carton(generar);


    @Test
    void tacharLinea(){
        Collection<Carton> cartones = new ArrayList<>();
        cartones.add(carton);
        Jugador jugador = new Jugador("David",cartones);
        Assertions.assertTrue(jugador.tachar(1).equals(EstadoPartida.INICIADA));
        Assertions.assertTrue(jugador.tachar(2).equals(EstadoPartida.INICIADA));
        Assertions.assertTrue(jugador.tachar(3).equals(EstadoPartida.INICIADA));
        Assertions.assertTrue(jugador.tachar(4).equals(EstadoPartida.INICIADA));
        Assertions.assertTrue(jugador.tachar(5).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(6).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(7).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(8).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(9).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(10).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(11).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(12).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(13).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(14).equals(EstadoPartida.LINEA));
        Assertions.assertTrue(jugador.tachar(15).equals(EstadoPartida.BINGO));
    }
    //cuanto canta linea y cuando canta bingo
    //Jugador tacha


}

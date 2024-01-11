package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PartidaTest {

    int[] numeros = new int[]{12,14,15,3};
    GeneradorNumeroTest generar = new GeneradorNumeroTest(numeros);
    IBombo bombo = new Bombo(generar);
    List<IJugador> jugadores = Arrays.asList(
            new JugadorPartida("David",1),new JugadorPartida("Mariano",2),
            new JugadorPartida("Gema",3),new JugadorPartida("Jose",4),
            new JugadorPartida("Angel",5)
    );
    Partida partida = new Partida(jugadores,bombo);

    @Test
    void cantarBingo(){
        IJugador jugadorGandor = partida.jugar();
        Assertions.assertTrue(jugadorGandor.getNombre().equals("Gema"));
    }

    void sacarBolasDelBombo(){

    }

    void tacharCarton(){

    }
}

class JugadorPartida implements IJugador {
    private final String nombre;
    private final int numero;

    JugadorPartida(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public EstadoPartida tachar(int bola) {
        if (bola == numero) return EstadoPartida.BINGO;
        else return EstadoPartida.INICIADA;
    }
}

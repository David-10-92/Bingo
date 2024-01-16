package org.david.ui;

import org.david.logica.*;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class PorConsola {

    private final static GeneracionNumeros generarNumeros = new GeneracionNumeros();
    private final static Lobby lobby = new Lobby(generarNumeros);


    public static void main(String[] args) {

        lobby.añadirJugador(IJugador.crearJugador("David",1));
        lobby.añadirJugador(IJugador.crearJugador("Gema",1));
        lobby.añadirJugador(IJugador.crearJugador("Mariano",2));
        lobby.añadirJugador(IJugador.crearJugador("Maria",1));
        Optional<IPartida> comienza = lobby.añadirJugador(IJugador.crearJugador("Antonio",1));

        Map<EstadoPartida,IJugador> jugadorGana = comienza.get().jugar();
        System.out.println(jugadorGana);
    }

}

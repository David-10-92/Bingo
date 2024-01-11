package org.david.ui;

import org.david.logica.GeneracionNumeros;
import org.david.logica.IJugador;
import org.david.logica.IPartida;
import org.david.logica.Lobby;

import java.util.Collection;
import java.util.Optional;

public class PorConsola {

    private final static GeneracionNumeros generarNumeros = new GeneracionNumeros();
    private final static Lobby lobby = new Lobby(generarNumeros);

    public static void main(String[] args) {

        lobby.añadirJugador(IJugador.crearJugador("David",2));
        lobby.añadirJugador(IJugador.crearJugador("Gema",1));
        lobby.añadirJugador(IJugador.crearJugador("Mariano",2));
        lobby.añadirJugador(IJugador.crearJugador("Maria",1));
        Optional<IPartida> comienza = lobby.añadirJugador(IJugador.crearJugador("Antonio",1));

        IJugador jugadorGana = comienza.get().jugar();
        System.out.println(jugadorGana.getNombre());
    }

}

package org.david.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lobby {
    private final List<IJugador> jugadores = new ArrayList<>();

    public Optional<Partida> añadirJugador(IJugador jugador) {
        jugadores.add(jugador);
        return nuevaPartida(jugadores);
    }

    private static Optional<Partida> nuevaPartida(List<IJugador> jugadores){
        if(jugadores.size() == 5) return Optional.of(new Partida());
        else return Optional.empty();
    }

}

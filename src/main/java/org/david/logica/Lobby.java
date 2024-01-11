package org.david.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lobby {

    private final IGeneracionNumeros generarNumero;
    private final List<IJugador> jugadores = new ArrayList<>();

    public Lobby(IGeneracionNumeros generarNumero) {
        this.generarNumero = generarNumero;
    }

    public Optional<Partida> añadirJugador(IJugador jugador) {
        jugadores.add(jugador);
        return nuevaPartida(jugadores);
    }

    private Optional<Partida> nuevaPartida(List<IJugador> jugadores){
        if(jugadores.size() == 5) {
            Partida partida = new Partida(jugadores, new Bombo(generarNumero));
            jugadores.clear();
            return Optional.of(partida);
        }
        else return Optional.empty();
    }
}

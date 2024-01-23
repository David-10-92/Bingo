package org.david.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Lobby {

    private final IGeneracionNumeros generarNumero;
    private final List<IJugador> jugadores = new ArrayList<>();

    @Autowired
    public Lobby(IGeneracionNumeros generarNumero) {
        this.generarNumero = generarNumero;
    }

    public Optional<IPartida> añadirJugador(IJugador jugador) {
        jugadores.add(jugador);
        return nuevaPartida(jugadores);
    }

    private Optional<IPartida> nuevaPartida(List<IJugador> jugadores){
        if(jugadores.size() == 5) {
            Partida partida = new Partida(jugadores, new Bombo(generarNumero));
            jugadores = new ArrayList<>();
            return Optional.of(partida);
        }
        else return Optional.empty();
    }
}

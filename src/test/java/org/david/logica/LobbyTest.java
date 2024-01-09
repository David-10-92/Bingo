package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LobbyTest {

    @Test
    void lobbyJugadores(){
        Lobby lobby = new Lobby();
        List<IJugador> jugadores = Arrays.asList(
                new JugadorLobby("David"),new JugadorLobby("Mariano"),
                new JugadorLobby("Gema"),new JugadorLobby("Jose"),
                new JugadorLobby("Angel")
        );

        List<Optional<Partida>> optionalList = jugadores.stream().map(lobby::añadirJugador).toList();
        List<Optional<Partida>> optionalListMenos1 = optionalList.;

        Assertions.assertTrue(optionalList.getLast().isPresent());
        Assertions.assertTrue(optionalList.removeLast());
    }
}

class JugadorLobby implements IJugador{
    private final String nombre;

    JugadorLobby(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

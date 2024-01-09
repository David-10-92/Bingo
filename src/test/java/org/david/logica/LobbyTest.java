package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LobbyTest {

    @Test
    void lobbyDevuelvePartidaAlAniadir5Jugadores(){
        Lobby lobby = new Lobby();
        List<IJugador> jugadores = Arrays.asList(
                new JugadorLobby("David"),new JugadorLobby("Mariano"),
                new JugadorLobby("Gema"),new JugadorLobby("Jose"),
                new JugadorLobby("Angel")
        );

        List<Optional<Partida>> optionalList = jugadores.stream().map(lobby::anadirJugador).toList();

        Assertions.assertTrue(optionalList.getLast().isPresent());

        List<Optional<Partida>> allMinusLast = optionalList.subList(0, optionalList.size());
        Assertions.assertTrue(allMinusLast.stream().allMatch(Optional::isEmpty));
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

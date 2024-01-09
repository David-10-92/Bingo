package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

public class LobbyTest {

    Lobby lobby = new Lobby();
    @Test
    void lobbyJugadores(){
        List<IJugador> jugadores = Arrays.asList(
                new JugadorLobby("David"),new JugadorLobby("Mariano"),
                new JugadorLobby("Gema"),new JugadorLobby("Jose"),
                new JugadorLobby("Angel")
        );

        List<Optional<Partida>> optionalList = jugadores.stream().map(lobby::añadirJugador).toList();
        List<Optional<Partida>> optionalLista = optionalList.subList(0,optionalList.size()-1);

        Assertions.assertTrue(optionalLista.stream().allMatch(Optional::isEmpty));
        Assertions.assertTrue(optionalList.getLast().isPresent());

    }

    @Test
    void LobbyContinua(){
        List<IJugador> jugadores = Arrays.asList(
                new JugadorLobby("David"),new JugadorLobby("Mariano"),
                new JugadorLobby("Gema"),new JugadorLobby("Jose"),
                new JugadorLobby("Angel")
        );
        jugadores.forEach(jugador -> lobby.añadirJugador(jugador));

        List<IJugador> jugadores2 = Arrays.asList(
                new JugadorLobby("David"),new JugadorLobby("Mariano"),
                new JugadorLobby("Gema"),new JugadorLobby("Jose"),
                new JugadorLobby("Angel")
        );
        List<Optional<Partida>> optionalList = jugadores2.stream().map(lobby::añadirJugador).toList();
        List<Optional<Partida>> optionalLista = optionalList.subList(0,optionalList.size()-1);

        Assertions.assertTrue(optionalLista.stream().allMatch(Optional::isEmpty));
        Assertions.assertTrue(optionalList.getLast().isPresent());

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

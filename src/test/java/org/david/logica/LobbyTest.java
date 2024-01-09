package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LobbyTest {
    Lobby lobby = new Lobby();

    private void verificarBatchJugadores(List<IJugador> jugadores) {
        List<Optional<Partida>> optionalList = jugadores.stream().map(lobby::anadirJugador).toList();

        Assertions.assertTrue(optionalList.getLast().isPresent());

        List<Optional<Partida>> allMinusLast = optionalList.subList(0, optionalList.size() - 1);
        Assertions.assertTrue(allMinusLast.stream().allMatch(Optional::isEmpty));
    }

    @Test
    void lobbyDevuelvePartidaAlAniadir5Jugadores(){

        List<IJugador> jugadores = Arrays.asList(
                new JugadorLobby("David"),new JugadorLobby("Mariano"),
                new JugadorLobby("Gema"),new JugadorLobby("Jose"),
                new JugadorLobby("Angel")
        );

        verificarBatchJugadores(jugadores);
    }

    @Test
    void unaVezDevueltaLaPrimeraPartidaElLobbyCreaUnaSegunda() {
        // Añadimos los primeros 5 jugadores
        List<IJugador> jugadores = Arrays.asList(
                new JugadorLobby("David"),new JugadorLobby("Mariano"),
                new JugadorLobby("Gema"),new JugadorLobby("Jose"),
                new JugadorLobby("Angel")
        );

        jugadores.forEach(lobby::anadirJugador);

        // Añadimos ahora otros 5 jugadores, y comprobamos lo mismo que en el test anterior
        List<IJugador> sigBatchJugadores = Arrays.asList(
                new JugadorLobby("Pepe"),new JugadorLobby("Jose"),
                new JugadorLobby("Manolo"),new JugadorLobby("El Del Bolo"),
                new JugadorLobby("Angel hermano")
        );

        verificarBatchJugadores(sigBatchJugadores);
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

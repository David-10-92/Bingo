package org.david.ui;

import org.david.logica.*;

import java.util.Map;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PorConsola {

    private final IGeneracionNumeros generarNumeros; // = new GeneracionNumeros();
    private final Lobby lobby; // = new Lobby(generarNumeros);

    public PorConsola(IGeneracionNumeros generarNumeros, Lobby lobby) {
        this.generarNumeros = generarNumeros;
        this.lobby = lobby;
    }

    public void jugar() {
        lobby.añadirJugador(IJugador.crearJugador("David",1));
        lobby.añadirJugador(IJugador.crearJugador("Gema",1));
        lobby.añadirJugador(IJugador.crearJugador("Mariano",2));
        lobby.añadirJugador(IJugador.crearJugador("Maria",1));
        Optional<IPartida> comienza = lobby.añadirJugador(IJugador.crearJugador("Antonio",1));

        Map<EstadoPartida,IJugador> jugadorGana = comienza.get().jugar();
        System.out.println(jugadorGana);
    }

    public static void main(String[] args) {
        // Bootstrap the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IGeneracionNumeros generacionNumeros = context.getBean(GeneracionNumeros.class);
        Lobby lobby = context.getBean(Lobby.class);

        PorConsola juego = new PorConsola(generacionNumeros, lobby);
        juego.jugar();
    }

}

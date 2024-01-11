package org.david.logica;

import java.util.ArrayList;
import java.util.Collection;

public interface IJugador {
    String getNombre();
    static IJugador crearJugador(String nombre,int numeroCartones) {
        Collection<Carton> cartones = new ArrayList<>();
        for(int i = 0 ; i < numeroCartones; i++){
            GeneracionNumeros generarNumero = new GeneracionNumeros();
            Carton carton = new Carton(generarNumero);
            cartones.add(carton);
        }
        return new Jugador(nombre,cartones);
    }
    EstadoPartida tachar(int bola);
}

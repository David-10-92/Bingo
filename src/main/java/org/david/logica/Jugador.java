package org.david.logica;

import java.util.Collection;

class Jugador implements IJugador{

    private final String name;
    private final Collection<Carton> cartones;

    public Jugador(String name, Collection<Carton> cartones) {
        this.name = name;
        this.cartones = cartones;
    }

    @Override
    public EstadoPartida tachar(int bola){
        Collection<EstadoPartida> estado =  cartones.stream().map(carton -> carton.tachar(bola)).toList();
        if(estado.contains(EstadoPartida.BINGO)){
            return EstadoPartida.BINGO;
        } else if (estado.contains(EstadoPartida.LINEA)) {
            return EstadoPartida.LINEA;
        }
        return EstadoPartida.INICIADA;
    }

    @Override
    public String getNombre() {
        return name;
    }

    @Override
    public String toString() {
        return "Jugador " +
                "name=" + name;
    }
}

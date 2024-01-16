package org.david.logica;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Partida implements IPartida{

    private final Collection<IJugador> jugadores;
    private final IBombo bombo;

    public Partida(Collection<IJugador> jugadores, IBombo bombo) {
        this.jugadores = jugadores;
        this.bombo = bombo;
    }

    @Override
    public Map<EstadoPartida,IJugador> jugar(){

        Map<EstadoPartida,IJugador> ganadores = new LinkedHashMap<>();
        EstadoPartida estado = EstadoPartida.INICIADA;
        IJugador ganador;

        do{
            int bola = bombo.generarBolaSinRepetir();
            List<EstadoPartida> estadoPartidaStream = jugadores.stream().map(jugador -> jugador.tachar(bola)).toList();
            List<IJugador> jugador = new ArrayList<>(jugadores);

                for(EstadoPartida e : estadoPartidaStream){
                    if(e.equals(EstadoPartida.LINEA) && estado == EstadoPartida.INICIADA){
                        int indice = estadoPartidaStream.indexOf(EstadoPartida.LINEA);
                        ganadores.put(estadoPartidaStream.get(indice),jugador.get(indice));
                        estado = EstadoPartida.LINEA;
                    }
                    else if(e.equals(EstadoPartida.BINGO) && estado == EstadoPartida.LINEA){
                        int indice = estadoPartidaStream.indexOf(EstadoPartida.BINGO);
                        ganadores.put(estadoPartidaStream.get(indice),jugador.get(indice));
                        estado = EstadoPartida.BINGO;
                    }
                    else{
                        ganador = null;
                    }
                }

        }while (estado != EstadoPartida.BINGO);

        return ganadores;
    }

}

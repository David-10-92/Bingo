package org.david.logica;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partida {

    private final Collection<IJugador> jugadores;
    private final IBombo bombo;

    public Partida(Collection<IJugador> jugadores, IBombo bombo) {
        this.jugadores = jugadores;
        this.bombo = bombo;
    }

    public IJugador jugar(){
        IJugador ganador = null;
        do{
            int bola = bombo.generarBolaSinRepetir();
            List<EstadoPartida> estadoPartidaStream = jugadores.stream().map(jugador -> jugador.tachar(bola)).toList();
            List<IJugador> jugadors = new ArrayList<>(jugadores);
            for(int i = 0; i < estadoPartidaStream.size();i++){
                if(estadoPartidaStream.get(i).equals(EstadoPartida.BINGO)){
                    ganador = jugadors.get(i);
                    break;
                }else{
                    ganador = null;
                }
            }
        }while (ganador == null);

        return ganador;
    }

    //Tachar los cartones de los jugadores
    //Ver si hay bingo
    //Ver si hay linea
}

package org.david.logica;

import java.util.*;

public class Carton {

    private Collection<Linea> carton = new ArrayList<>();
    public Carton(IGeneracionNumeros genereadorNumeros){
        for(int linea = 0 ; linea < 3 ; linea ++){
            carton.add(generarLinea(genereadorNumeros));
        }
    }

    private Linea generarLinea(IGeneracionNumeros genereadorNumeros){
        Collection<Integer> numsLinea = new ArrayList<>();
        for(int numeroLinea = 0; numeroLinea < 5; numeroLinea++){
            numsLinea.add(genereadorNumeros.generarBolaSinRepetir());
        }
        return new Linea(numsLinea);
    }

    enum EstadoLinea{
        COMPLETA,INCOMPLETA;
    }

    static  class Linea{
        private final Collection<Integer> numero;

        Linea(Collection<Integer> numero) {
            this.numero = numero;
        }
        public EstadoLinea tacha(int n){
            numero.remove(n);
            return numero.isEmpty() ? EstadoLinea.COMPLETA : EstadoLinea.INCOMPLETA;
        }
    }

    public EstadoPartida tachar(int bola){
        Collection<EstadoLinea> estadoLineas =  carton.stream().map(linea -> linea.tacha(bola)).toList();

        boolean todasLineasTachadas = estadoLineas.stream().allMatch(estadoLinea -> estadoLinea.equals(EstadoLinea.COMPLETA));
        boolean algunaLineaTachada = estadoLineas.stream().anyMatch(estadoLinea -> estadoLinea.equals(EstadoLinea.COMPLETA));

        if(todasLineasTachadas) return EstadoPartida.BINGO;
        else if (algunaLineaTachada) return EstadoPartida.LINEA;
        else return EstadoPartida.INICIADA;
    }
}
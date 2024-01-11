package org.david.logica;

import java.util.Set;
import java.util.TreeSet;

class Bombo implements IBombo{

    private final IGeneracionNumeros numeros;

    public Bombo(IGeneracionNumeros numeros) {
        this.numeros = numeros;
    }

    @Override
    public int generarBolaSinRepetir() {
        return numeros.generarNumero1a90();
    }

}

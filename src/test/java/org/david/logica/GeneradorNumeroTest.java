package org.david.logica;

import java.util.Set;
import java.util.TreeSet;

public class GeneradorNumeroTest implements IGeneracionNumeros{

    private int[] numeros;
    private int posicion = 0;
    @Override
    public int generarNumero1a90() {
        int resultado = numeros[posicion];
        posicion++;
        return resultado;
    }

    public GeneradorNumeroTest(int[] numeros) {
        this.numeros = numeros;
    }
}

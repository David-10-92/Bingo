package org.david.logica;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Bombo implements IGeneracionNumeros{

    Set<Integer> bolas = new TreeSet<>();
    @Override
    public int generarBolaSinRepetir() {
        if(bolas.size() == 90){
            throw new BomboVacioExeption();
        }
        int num;
        do{
            num = generarBola();
        }while (bolas.contains(num));
        bolas.add(num);
        return num;
    }

    private int generarBola(){
        return (int)Math.floor(Math.random()*90+1);
    }
}

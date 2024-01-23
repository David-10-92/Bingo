package org.david.logica;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;

@Component
public class GeneracionNumeros implements IGeneracionNumeros{

    private final Set<Integer> bolas = new TreeSet<>();

    @Override
    public int generarNumero1a90() {
        int num;

        if(bolas.size() == 90){
            throw new BomboVacioExeption();
        }
        do{
            num = (int)Math.floor(Math.random()*90+1);
        }while (bolas.contains(num));
        bolas.add(num);
        return num;
    }
}

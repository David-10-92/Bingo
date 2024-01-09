package org.david.logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BomboTest {

    @Test
    void sacarBolaSinRepetir(){
        Bombo bombo = new Bombo();
        Set<Integer> numeros = new TreeSet<>();
        while (numeros.size()!=90){
            int num = bombo.generarBolaSinRepetir();
            numeros.add(num);
        }
        Assertions.assertTrue(numeros.size()==90);

    }

    @Test
    void sacarBolaSinRepetir90(){
        Bombo bombo = new Bombo();
        Set<Integer> numeros = new TreeSet<>();
        for(int i = 0; i<90; i++){
            int num = bombo.generarBolaSinRepetir();
            numeros.add(num);
        }
        Assertions.assertTrue(numeros.size()==90);
    }

    @Test
    void sacarBolaSinRepetir90VariasVeces(){
        Bombo bombo = new Bombo();
        List<Integer> numeros = new ArrayList<>();
        List<Integer> numeros2 = new ArrayList<>();
        for(int i = 0; i<90; i++){
            int num = bombo.generarBolaSinRepetir();
            numeros.add(num);
        }
        Bombo bombo2 = new Bombo();
        for(int i = 0; i<90; i++){
            int num = bombo2.generarBolaSinRepetir();
            numeros2.add(num);
        }
        Assertions.assertEquals(numeros.size(),numeros2.size());
        Assertions.assertNotEquals(numeros2,numeros);
    }

    @Test
    void siPedimosMasDe90Numeros(){
        Bombo bombo = new Bombo();
        Set<Integer> numeros = new TreeSet<>();
        for(int i = 0; i<90; i++){
            int num = bombo.generarBolaSinRepetir();
            numeros.add(num);
        }
        Assertions.assertThrows(BomboVacioExeption.class,() -> bombo.generarBolaSinRepetir());
    }
}

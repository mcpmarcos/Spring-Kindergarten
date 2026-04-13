package com.marcos.mcp.lab_padroes_projeto_spring.model;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public class NumberGenerator {

    // Mockando métodos estáticos

    
    
    private static SplittableRandom random = new SplittableRandom();

    private NumberGenerator(){
    }

    public static List<Integer> generateRandomNumbers(int listSize){
        return random.ints().boxed().limit(listSize).collect(Collectors.toList());
    }

    public static List<Integer> generateRandomNumbers(){
        return random.ints().boxed().limit(random.nextInt(10)).collect(Collectors.toList());
    }
}

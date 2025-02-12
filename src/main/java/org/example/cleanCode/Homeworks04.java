package org.example.cleanCode;

import java.util.List;
import java.util.Map;

public class Homeworks04 {

    private boolean isRedFruit(String fruit){
        List<String> redFruits = List.of(
                "manzana",
                "cereza",
                "ciruela"
        );
        return redFruits.contains(fruit);
    }

    private List<String> getFruitsByColor(String color) {
        Map<String, List<String>> fruitsByColor = Map.of(
                "red", List.of("manzana", "fresa"),
                "yellow", List.of("piña", "banana"),
                "purple", List.of("moras", "uvas")
        );

        if (!fruitsByColor.containsKey(color))
            throw new RuntimeException("the color must be: red, yellow, purple");

        return fruitsByColor.get(color);
    }

    private String workingSteps(){
        boolean isFirstStepWorking  = true;
        boolean isSecondStepWorking = true;
        boolean isThirdStepWorking  = true;
        boolean isFourthStepWorking = true;

        if( !isFirstStepWorking ) return "First step broken.";

        if( !isSecondStepWorking ) return "Second step broken.";

        if( !isThirdStepWorking ) return "Third step broken.";

        if( !isFourthStepWorking ) return "Fourth step broken.";

        return "Working properly!";
    }

    public void run() {
        System.out.println(isRedFruit("cereza") + ", fruit: cereza");
        System.out.println(isRedFruit("piña") + ", fruit: piña");

        System.out.println(getFruitsByColor("red") + ", color: red");
        System.out.println(getFruitsByColor("yellow") + ", color: yellow");
        System.out.println(getFruitsByColor("purple") + ", color: purple");
        System.out.println(getFruitsByColor("green") + ", color: green");

        System.out.println(workingSteps());
    }
}

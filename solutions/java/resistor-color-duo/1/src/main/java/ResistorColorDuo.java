import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColorDuo {
    private Map<String, Integer> colourMap;

    public ResistorColorDuo() {
        colourMap = new LinkedHashMap<>();
        colourMap.put("black", 0);
        colourMap.put("brown", 1);
        colourMap.put("red", 2);
        colourMap.put("orange", 3);
        colourMap.put("yellow", 4);
        colourMap.put("green", 5);
        colourMap.put("blue", 6);
        colourMap.put("violet", 7);
        colourMap.put("grey", 8);
        colourMap.put("white", 9);
    }

    int value(String[] colors) {
        return Integer.parseInt(
                Arrays.stream(colors)
                        .limit(2)
                        .reduce("", (acc, c) -> acc + colourMap.get(c))
        );
    }
}

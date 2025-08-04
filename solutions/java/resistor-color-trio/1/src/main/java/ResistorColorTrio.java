import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColorTrio {

    private Map<String, Integer> colourMap;

    public ResistorColorTrio() {
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

    private static String ohmsStr = "%sohms";

    String label(String[] colors) {
        final var ohms = calculateOhms(colors);
        return String.format(ohmsStr, calculateMetricPrefix(ohms, colourMap.get(colors[2])));
    }

    private int calculateOhms(String[] colors) {
        return Integer.parseInt(
                Arrays.stream(colors)
                        .limit(2)
                        .reduce("", (acc, c) -> acc + colourMap.get(c))
        );
    }
    
    private String calculateMetricPrefix(int ohms, int metric) {
        final var combined = ohms * Math.pow(10, metric);
        if (combined == 0) {
            return (int) combined + " ";
        } else if (combined % 1000000000 == 0) {
            return (int) (combined / 1000000000) + " giga";
        } else if (combined % 1000000 == 0) {
           return (int) (combined / 1000000) + " mega";
        } else if (combined % 1000 == 0) {
            return (int) (combined / 1000) + " kilo";
        } else {
            return (int) combined + " ";
        }
    }
}

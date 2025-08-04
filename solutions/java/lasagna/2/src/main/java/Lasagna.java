public class Lasagna {

    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int actualMinutesInOven) {
        return expectedMinutesInOven() - actualMinutesInOven;
    }

    public int preparationTimeInMinutes(int numOfLayers) {
        return numOfLayers * 2;
    }

    public int totalTimeInMinutes(int numOfLayers, int actualMinutesInOven) {
        return preparationTimeInMinutes(numOfLayers) + actualMinutesInOven;
    }
}

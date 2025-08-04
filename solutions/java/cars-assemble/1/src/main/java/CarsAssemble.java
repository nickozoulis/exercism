public class CarsAssemble {

    private static int CARS_ASSEMBLY_NUM = 221;

    public double productionRatePerHour(int speed) {
            if (0 <= speed && speed <= 4) {
                return speed * CARS_ASSEMBLY_NUM;
            } else if (5 <= speed && speed <= 8) {
                return speed * CARS_ASSEMBLY_NUM * 0.9;
            } else if (speed == 9) {
                return speed * CARS_ASSEMBLY_NUM * 0.8;
            } else if (speed == 10) {
                return speed * CARS_ASSEMBLY_NUM * 0.77;
            } else {
                throw new RuntimeException();
            }
    }

    public int workingItemsPerMinute(int speed) {
        return  (int)productionRatePerHour(speed) / 60;
    }
}

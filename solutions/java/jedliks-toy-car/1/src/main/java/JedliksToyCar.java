public class JedliksToyCar {
    private int distance = 0;
    private int battery = 100;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", getDistance());
    }

    public String batteryDisplay() {
        if (getBattery() <= 0) {
            return "Battery empty";
        } else {
            return String.format("Battery at %d%%", getBattery());
        }
    }

    public void drive() {
        if (getBattery() > 0) {
            setDistance(getDistance() + 20);
            setBattery(getBattery() - 1);
        }
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

}

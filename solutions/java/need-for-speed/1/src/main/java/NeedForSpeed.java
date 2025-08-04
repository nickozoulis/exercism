class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distanceDriven = 0;
    private int batteryPercentage = 100;

    NeedForSpeed(int speed, int batteryDrain) {
        setSpeed(speed);
        setBatteryDrain(batteryDrain);
    }

    public boolean batteryDrained() {
        return getBatteryPercentage() < getBatteryDrain();
    }

    public int distanceDriven() {
        return getDistanceDriven();
    }

    public void drive() {
        if (getBatteryPercentage() > 0) {
            setDistanceDriven(getDistanceDriven() + getSpeed());
            setBatteryPercentage(getBatteryPercentage() - getBatteryDrain());
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBatteryDrain() {
        return batteryDrain;
    }

    public void setBatteryDrain(int batteryDrain) {
        this.batteryDrain = batteryDrain;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public void setDistanceDriven(int distanceDriven) {
        this.distanceDriven = distanceDriven;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }
}

class RaceTrack {
    private int distance;

    RaceTrack(int distance) {
        setDistance(distance);
    }

    public boolean canFinishRace(NeedForSpeed car) {
        return getDistance() <= (100 / car.getBatteryDrain()) * car.getSpeed();
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

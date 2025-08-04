class ProductionRemoteControlCar implements RemoteControlCar, Comparable {
    private int distanceTravelled;
    private int numberOfVictories;

    public void drive() {
        distanceTravelled += 10;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories += numberOfVictories;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof ProductionRemoteControlCar) {
            ProductionRemoteControlCar that = (ProductionRemoteControlCar) o;
            return Integer.compare(that.numberOfVictories, this.numberOfVictories);
        }
        throw new RuntimeException();
    }
}

package org.example.rccars;

public class ProductionRemoteControlCar implements RemoteControlCar, Comparable {

    private static final int MOVE_UNITS = 10;

    private int distanceTravelled;
    private int numberOfVictories;

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public void drive() {
        distanceTravelled += MOVE_UNITS;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    @Override
    public int compareTo(Object o) {
        return ((ProductionRemoteControlCar) o).numberOfVictories - this.numberOfVictories;
    }
}

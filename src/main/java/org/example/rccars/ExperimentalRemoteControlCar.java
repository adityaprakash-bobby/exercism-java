package org.example.rccars;

public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private static final int MOVE_UNITS = 20;

    private int distanceTravelled;

    @Override
    public void drive() {
        distanceTravelled += MOVE_UNITS;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}

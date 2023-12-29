package org.example;

public class CarsAssemble {

    private static final int CARS_PER_HOUR_1_SPEED = 221;

    private static int getIdealProductionCountPerHour(int speed) {
        assert (speed >= 0 && speed <= 10);

        return CARS_PER_HOUR_1_SPEED * speed;
    }

    private static double getSuccessRate(int speed) {
        assert (speed >= 0 && speed <= 10);

        if (speed >= 1 && speed <= 4) return 1;
        else if (speed >= 5 && speed <= 8) return 0.9;
        else if (speed == 9) return 0.8;
        else if (speed == 10) return 0.77;
        else return 0;
    }

    public double productionRatePerHour(int speed) {
        return getIdealProductionCountPerHour(speed) * getSuccessRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}
package org.example;


public class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int i = 0; i < birdsPerDay.length; i++) {
            if (birdsPerDay[i] == 0) return true;
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int minDaysToConsider = Math.min(numberOfDays, birdsPerDay.length);
        int birdCount = 0;

        for (int i = 0; i < minDaysToConsider; i++) {
            birdCount += birdsPerDay[i];
        }

        return birdCount;
    }

    public int getBusyDays() {
        int busyDays = 0;

        for (int i = 0; i < birdsPerDay.length; i++) {
            if (birdsPerDay[i] >= 5) busyDays++;
        }

        return busyDays;
    }
}


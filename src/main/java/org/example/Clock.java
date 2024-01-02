package org.example;

class Clock {

    private static final int DAY_MINUTES = 1440;
    private static final int HOUR_MINUTES = 60;

    private int minutes;

    Clock(int hours, int minutes) {
        this.minutes = normalize(hours * HOUR_MINUTES + minutes);
    }

    void add(int minutes) {
        this.minutes = normalize(minutes + this.minutes);
    }

    private static int normalize(int minutes) {
        return minutes < 0 ? DAY_MINUTES + (minutes % DAY_MINUTES) : minutes % DAY_MINUTES;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", minutes / HOUR_MINUTES, minutes % HOUR_MINUTES);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (null == obj) return false;
        if (getClass() != obj.getClass()) return false;

        Clock clock = (Clock) obj;

        return minutes == clock.minutes;
    }
}

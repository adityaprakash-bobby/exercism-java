package org.example;

class NeedForSpeed {
	private int speed;
	private int batteryDrain;
	private int distanceDriven = 0;
	private int batteryCharge = 100;
	
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return batteryCharge - batteryDrain < 0;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (batteryDrained()) return;
        
        batteryCharge -= batteryDrain;
        distanceDriven += speed;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
	private int distance;
	
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while(car.distanceDriven() < distance && !car.batteryDrained()) {
        	car.drive();
        }
        
        return car.distanceDriven() >= distance;
    }
}

package org.example;

public class ElonsToyCar {
	private int batteryPercentage = 100;
	private int distanceDriven = 0;

	public static ElonsToyCar buy() {
		return new ElonsToyCar();
	}

	public String distanceDisplay() {
		return String.format("Driven %d meters", distanceDriven);
	}

	public String batteryDisplay() {
		if (batteryPercentage == 0)
			return "Battery empty";
		else
			return String.format("Battery at %d%%", batteryPercentage);
	}

	public void drive() {
		if (batteryPercentage == 0)
			return;

		batteryPercentage -= 1;
		distanceDriven += 20;
	}
}

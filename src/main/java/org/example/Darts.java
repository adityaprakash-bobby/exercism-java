package org.example;

import java.util.function.DoublePredicate;

public class Darts {
	private static final int INNER_RING = 1;
	private static final int MIDDLE_RING = 5;
	private static final int OUTER_RING = 10;
	
	int score(double xOfDart, double yOfDart) {
		double distance = Math.hypot(xOfDart, yOfDart);
		DoublePredicate pointWithin = ring -> distance <= ring;
		
		if (pointWithin.test(INNER_RING))
			return 10;
		else if (pointWithin.test(MIDDLE_RING))
			return 5;
		else if (pointWithin.test(OUTER_RING))
			return 1;
		else
			return 0;
	}
}

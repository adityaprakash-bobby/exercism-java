package org.example;

import java.util.Random;

class Robot {
	private static int count = 0;
	private String name;
	private Random random;
	
	public Robot() {
		random = new Random(count);
		generateName();
		count++;
	}
	
    String getName() {
        return name;
    }

    void reset() {
        generateName();
    }
    
    private void generateName() {
    	
    	int firstLetter = 'A' + random.nextInt(26);
    	int secondLetter = 'A' + random.nextInt(26);
    	int number = random.nextInt(1000);
    
    	StringBuilder newName = new StringBuilder();
    	newName.appendCodePoint(firstLetter);
    	newName.appendCodePoint(secondLetter);
    	newName.append(String.format("%3d", number));
    	
    	name = newName.toString();
    }

}

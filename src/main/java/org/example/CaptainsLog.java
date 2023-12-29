package org.example;

import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private final Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        int planetIdx = random.nextInt(10);

        return PLANET_CLASSES[planetIdx];
    }

    String randomShipRegistryNumber() {
        int registryNumber = 1000 + random.nextInt(9000);

        return "NCC-" + registryNumber;
    }

    double randomStardate() {
        return 41000.0 + 1000.0 * random.nextDouble();
    }
}
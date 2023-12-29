package org.example.handshakecalculator;

import java.util.List;
import java.util.Vector;

public class HandshakeCalculator {
    List<Signal> calculateHandshake(int number) {
        List<Signal> result = new Vector<>();
        int signalStart = 0, signalIncrement = 1, signalEnd = Signal.values().length;

        if ((number & 16) != 0) {
            signalStart = 3;
            signalIncrement = -1;
            signalEnd = -1;
        }

        for (; signalStart != signalEnd; signalStart += signalIncrement) {
            if ((number & (1 << signalStart)) != 0) {
                result.add(Signal.values()[signalStart]);
            }
        }

        return result;
    }
}

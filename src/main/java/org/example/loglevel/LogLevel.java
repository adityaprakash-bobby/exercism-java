package org.example.loglevel;

public enum LogLevel {
    UNKNOWN(0),
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42);

    private final int encodedLogLevel;

    LogLevel(int encodedLogLevel) {
        this.encodedLogLevel = encodedLogLevel;
    }

    public int getEncodedLogLevel() {
        return encodedLogLevel;
    }
}

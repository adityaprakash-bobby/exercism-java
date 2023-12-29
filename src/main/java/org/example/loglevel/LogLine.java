package org.example.loglevel;

public class LogLine {

    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String level = logLine.substring(logLine.indexOf('[') + 1, logLine.indexOf(']'));

        return switch (level) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    public String getOutputForShortLog() {
        String message = logLine.substring(logLine.indexOf(']') + 3);
        LogLevel logLevel = getLogLevel();

        return String.format("%d:%s", logLevel.getEncodedLogLevel(), message);
    }
}

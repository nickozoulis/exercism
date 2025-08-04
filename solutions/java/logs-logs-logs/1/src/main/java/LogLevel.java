public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42),
    UNKNOWN(0);

    private final int logLevel;


    LogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    public int getLogLevel() {
        return logLevel;
    }

     public static LogLevel convert(String shortening) {
        return switch (shortening) {
            case "TRC" -> TRACE;
            case "DBG" -> DEBUG;
            case "INF" -> INFO;
            case "WRN" -> WARNING;
            case "ERR" -> ERROR;
            case "FTL" -> FATAL;
            default -> UNKNOWN;
        };
    }

}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLine {
    private static Pattern pattern = Pattern.compile("\\[(.*)\\]:(.*)", Pattern.CASE_INSENSITIVE);
    private LogLevel logLevel;
    private String message;

    public LogLine(String logLine) {
        Matcher matcher = pattern.matcher(logLine);
        if (matcher.find()) {
            logLevel = LogLevel.convert(matcher.group(1).trim());
            message = matcher.group(2).trim();
        } else {
            throw new RuntimeException();
        }
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getOutputForShortLog() {
        return String.format("%d:%s", logLevel.getLogLevel(), message);
    }
}

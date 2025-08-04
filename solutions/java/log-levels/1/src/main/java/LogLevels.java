import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {

    static Pattern pattern = Pattern.compile("\\[(.*)\\]:(.*)", Pattern.CASE_INSENSITIVE);

    public static String message(String logLine) {
        Matcher matcher = pattern.matcher(logLine);
        if (matcher.find()) {
            return matcher.group(2).trim();
        } else {
            throw new RuntimeException();
        }
    }

    public static String logLevel(String logLine) {
        Matcher matcher = pattern.matcher(logLine);
        if (matcher.find()) {
            return matcher.group(1).trim().toLowerCase();
        } else {
            throw new RuntimeException();
        }
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }
}

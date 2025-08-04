import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private LocalDateTime dtm;
    private static BigInteger _GIGASECOND = BigInteger.valueOf(1_000_000_000L);

    public Gigasecond(LocalDate moment) {
        dtm = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        dtm = moment;
    }

    public LocalDateTime getDateTime() {
       return dtm.plusSeconds(_GIGASECOND.longValue());
    }
}

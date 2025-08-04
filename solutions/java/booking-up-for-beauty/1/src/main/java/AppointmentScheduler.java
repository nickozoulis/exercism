import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class AppointmentScheduler {
    // 7/25/2019 13:45:00
    private static String dateFormat = "MM/dd/yyyy HH:mm:ss";
    private static DateTimeFormatter parser = DateTimeFormatter.ofPattern(dateFormat);
    private static String descriptionTemplate = "You have an appointment on %s, at %s.";
    private static String printerFormat1 = "EEEE, MMMM d, yyyy";
    private static String printerFormat2 = "h:mm a";
    private static DateTimeFormatter printer1 = DateTimeFormatter.ofPattern(printerFormat1);
    private static DateTimeFormatter printer2 = DateTimeFormatter.ofPattern(printerFormat2);

    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return appointmentDate.getHour() >= 12 && appointmentDate.getHour() < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return String.format(descriptionTemplate, appointmentDate.format(printer1), appointmentDate.format(printer2).toUpperCase());
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    }
}

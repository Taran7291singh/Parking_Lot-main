import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;


public class TotalTime {

    public static int[] calculateTime(String enterDate, String exitDate, String enterTime, String exitTime) {
        LocalTime enterLocalTime = LocalTime.parse(enterTime, DateTimeFormatter.ofPattern("hh:mm a"));
        LocalTime exitLocalTime = LocalTime.parse(exitTime, DateTimeFormatter.ofPattern("hh:mm a"));

        long hours = enterLocalTime.until(exitLocalTime, ChronoUnit.HOURS);
        long minutes = enterLocalTime.until(exitLocalTime, ChronoUnit.MINUTES) % 60;

        // Adjust for crossing midnight
        if (exitLocalTime.isBefore(enterLocalTime)) {
            hours += 24;
        }

        // Calculate total days between enterDate and exitDate (exclusive)
        int days = (int) ChronoUnit.DAYS.between(LocalDate.parse(enterDate), LocalDate.parse(exitDate));

        // Subtract one day if there is only one day between enterDate and exitDate
        if (days == 1) {
            hours -= 24;
        } else if (days > 1) {
            hours += (days - 1) * 24;
        }

        return new int[]{(int) hours, (int) minutes};
    }

}

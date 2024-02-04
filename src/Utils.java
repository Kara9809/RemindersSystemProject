
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class Utils {
    public static boolean equals(LocalDateTime ldt1, LocalDateTime ldt2) {
        return ldt1.getYear() == ldt2.getYear() &&
                ldt1.getMonth() == ldt2.getMonth() &&
                ldt1.getDayOfMonth() == ldt2.getDayOfMonth() &&
                ldt1.getHour() == ldt2.getHour() &&
                ldt1.getMinute() == ldt2.getMinute();
    }

    public static Set<Reminder> init(int len) {
        Set<Reminder> reminders = new TreeSet<>();

        for (int i = 0; i < len; i++) {
            LocalDateTime expiration = LocalDateTime.now().plusMinutes(i);
            Reminder reminder = new Reminder("Reminder" + (i + 1), expiration, Urgency.rand());
            reminders.add(reminder);
        }
        return reminders;
    }
}
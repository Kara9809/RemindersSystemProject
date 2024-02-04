
import java.time.LocalDateTime;
import java.util.Set;


public class ReminderTask extends Thread {

    private boolean quit;
    private final Set<Reminder> reminders;

    public ReminderTask(Set<Reminder> reminders) {
        this.reminders = reminders;
        this.quit = false;
    }

    @Override
    public void run() {
        while (!quit) {
            for (Reminder reminder : reminders) {
                if (reminder.getIsPoped()) {
                    continue;
                }
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime expiration = reminder.getExpiration();
                if (Utils.equals(now, expiration)) {
                    switch (reminder.getUrgency()) {
                        case NORMAL -> System.out.println(reminder.getText());
                        case IMPORTANT -> System.out.println(reminder.getText().toUpperCase());
                        case CRITICAL -> System.out.println("!!!" + reminder.getText().toUpperCase() + "!!!");
                    }
                    reminder.setIsPoped(true);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void end() {
        this.quit = true;
    }
}


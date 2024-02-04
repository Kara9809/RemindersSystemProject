
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

public class Reminder implements Comparable<Reminder> {
    private String text;
    private LocalDateTime expiration;
    private Urgency urgency;
    private boolean isPoped;

    public Reminder(String text, LocalDateTime expiration, Urgency urgency, boolean isPoped) {
        this.text = text;
        this.expiration = expiration;
        this.urgency = urgency;
        this.isPoped = isPoped;
    }

    public Reminder(String text, LocalDateTime expiration, Urgency urgency) {
        this(text, expiration, urgency, false);
    }

    public Reminder(String text, LocalDateTime expiration) {
        this(text, expiration, Urgency.NORMAL);
    }

    public Reminder(String text, Urgency urgency) {
        this(text, LocalDateTime.now(), urgency);
    }

    @Override
    public int compareTo(Reminder other) {
        return this.expiration.compareTo(other.expiration);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Reminder) {
            Reminder otherReminder = (Reminder) other;
            return this.text.equals(otherReminder.text);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.text.hashCode();
    }

    public String getText() {
        return this.text;
    }

    public LocalDateTime getExpiration() {
        return this.expiration;
    }

    public Urgency getUrgency() {
        return this.urgency;
    }

    public boolean getIsPoped() {
        return this.isPoped;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public void setIsPoped(boolean isPoped) {
        this.isPoped = isPoped;
    }

    @Override
    public String toString() {
        return String.format("Reminder: %s, Expiration: %s, IsPoped: %s", this.text, this.expiration, this.isPoped);
    }


}

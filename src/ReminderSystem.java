import java.time.LocalDateTime;
import java.util.*;

public class ReminderSystem {

    private static Scanner scanner;
    private static ReminderSystem instance;
    private Set<Reminder> reminders;
    private ReminderTask task;

    private ReminderSystem() {
        reminders = Utils.init(10);
    }

    public static ReminderSystem getInstance() {
        if (instance == null) {
            synchronized (ReminderSystem.class) {
                if (instance == null) {
                    instance = new ReminderSystem();
                }
            }
        }
        return instance;
    }

    public void start() {
        System.out.println("Now we start a system");
        scanner = new Scanner(System.in);
        task = new ReminderTask(reminders);
        task.setDaemon(true);
        task.start();
        program();
    }

    public void program() {
        boolean running = true;
        while (running) {
            menu();
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    addReminder();
                    break;
                case 2:
                    displaySorted();
                    break;
                case 3: {
                    end();
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid input. Please try again");
            }
        }

    }

    public void menu() {
        System.out.println(" Reminder system Menu :");
        System.out.println(" 1. Add a new reminder");
        System.out.println(" 2. Print all reminders with a sort");
        System.out.println(" 3. Exit the program");
    }

    public void end() {
        scanner.close();
        task.end();
    }

    public void displaySorted() {
        List<Reminder> remindersList = new ArrayList<>(reminders);
        Collections.sort(remindersList);
        System.out.println(remindersList);
    }

    public void addReminder() {
        System.out.println("Please insert text: ");
        String text = scanner.nextLine();
        System.out.println("How many minutes to remind you? Please insert :");
        int minutes = scanner.nextInt();
        scanner.nextLine();
        Reminder reminder = new Reminder(text, LocalDateTime.now().plusMinutes(minutes));
        reminders.add(reminder);
    }

}




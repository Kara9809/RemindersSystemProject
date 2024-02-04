public enum Urgency {
    NORMAL,
    IMPORTANT,
    CRITICAL;

    public static Urgency rand() {
        Urgency[] urgencies = Urgency.values();
        int rand = (int) (Math.random() * urgencies.length);
        return urgencies[rand];
    }
}

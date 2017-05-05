package P02;

public class Message {
    private Importance importance;
    private String message;

    public Message(String importance, String message) {
        this.importance = Importance.valueOf(importance);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.importance + ": " + this.message;
    }

    public int compareWeekday(Importance importance) {
        return this.importance.compareTo(importance);
    }
}

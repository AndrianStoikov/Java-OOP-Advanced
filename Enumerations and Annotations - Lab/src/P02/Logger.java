package P02;

import java.util.ArrayList;
import java.util.List;


public class Logger {
    private Importance importance;
    private List<Message> messages;

    public Logger(String importance) {
        this.importance = Importance.valueOf(importance);
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        if(message.compareWeekday(this.importance) < 0)
            return;

        this.messages.add(message);
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}

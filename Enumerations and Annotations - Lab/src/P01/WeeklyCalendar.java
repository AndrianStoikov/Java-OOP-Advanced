package P01;

import java.util.ArrayList;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        this.entries.add(new WeeklyEntry(weekday, notes));
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        ArrayList<WeeklyEntry> entries = new ArrayList<>(this.entries);
        entries.sort(WeeklyEntry.compareByWeekday());
        return entries;
    }
}

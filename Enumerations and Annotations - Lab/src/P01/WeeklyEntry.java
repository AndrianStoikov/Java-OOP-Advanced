package P01;

import java.util.Comparator;

public class WeeklyEntry {
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Weekday.valueOf(weekday);
        this.notes = notes;
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }

    public static Comparator<WeeklyEntry> compareByWeekday() {
        return Comparator.comparing(a -> a.weekday);
    }
}

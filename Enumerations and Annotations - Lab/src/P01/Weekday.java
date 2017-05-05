package P01;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        String name = super.toString().substring(1).toLowerCase();
        return super.toString().substring(0, 1) + name;
    }
}

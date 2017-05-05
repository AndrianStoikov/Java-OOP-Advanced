package P01;

public class Main {
    public static void main(String[] args) {
        Weekday weekday = Weekday.valueOf(Weekday.class, "MONDAY");
        System.out.println(weekday);
    }
}

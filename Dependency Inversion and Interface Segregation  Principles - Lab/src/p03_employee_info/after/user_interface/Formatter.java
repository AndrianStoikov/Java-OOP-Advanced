package p03_employee_info.after.user_interface;

public interface Formatter {
    <T> String format(Iterable<T> items);
}

package p03_employee_info.after.user_interface;

import java.util.Comparator;

public interface InfoProvider<T> {

    Iterable<T> getBy(Comparator<T> comparator);
}

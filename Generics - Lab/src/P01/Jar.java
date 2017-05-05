package P01;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {
    private List<T> list;

    public Jar() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove() {
        return this.list.remove(this.list.size() - 1);
    }
}

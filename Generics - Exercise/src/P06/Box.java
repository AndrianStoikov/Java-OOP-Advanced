package P06;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> items;

    public Box(){
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);
    }

    public void swap(int ind1, int ind2) {
        T buff = this.items.get(ind1);
        T second = this.items.get(ind2);
        this.items.set(ind1, second);
        this.items.set(ind2, buff);
    }

    public Integer compare(T compareWith) {
        int count = 0;
        for (T element : items) {
            int result = element.compareTo(compareWith);
            if(result > 0)
                count++;
        }

        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : items) {
            sb.append(element.getClass().getName()).append(": ").append(element);
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}

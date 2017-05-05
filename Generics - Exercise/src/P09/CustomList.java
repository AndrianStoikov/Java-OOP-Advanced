package P09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> items;

    public CustomList() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);
    }

    public T remove(int index) {
        return this.items.remove(index);
    }

    public boolean contains(T element) {
        return this.items.contains(element);
    }

    public void swap(int index1, int index2) {
        T buff = this.items.get(index1);
        T second = this.items.get(index2);
        this.items.set(index1, second);
        this.items.set(index2, buff);
    }

    public int countGreaterThat(T elementToCompare) {
        int count = 0;
        for (T item : this.items) {
            int result = item.compareTo(elementToCompare);
            if (result > 0)
                count++;
        }

        return count;
    }

    public T getMax() {
        T max = this.items.get(0);

        for (int i = 1; i < this.items.size(); i++) {
            if (this.items.get(i).compareTo(max) > 0)
                max = this.items.get(i);
        }

        return max;
    }

    public T getMin() {
        T min = this.items.get(0);

        for (int i = 1; i < this.items.size(); i++) {
            if (this.items.get(i).compareTo(min) < 0)
                min = this.items.get(i);
        }

        return min;
    }

    public void Sort() {
        this.items.sort(Comparator.naturalOrder());
    }

    @Override
    public Iterator<T> iterator() {
        return this.items.iterator();
    }
}

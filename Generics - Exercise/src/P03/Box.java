package P03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 18.3.2017 г..
 */
public class Box<T> {
    private List<T> item;

    public Box(){
        this.item= new ArrayList<>();
    }

    public void add(T item) {
        this.item.add(item);
    }

    public void swap(int ind1, int ind2) {
        T buff = this.item.get(ind1);
        T second = this.item.get(ind2);
        this.item.set(ind1, second);
        this.item.set(ind2, buff);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : item) {
            sb.append(element.getClass().getName()).append(": ").append(element);
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}

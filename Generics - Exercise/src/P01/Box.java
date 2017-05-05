package P01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 18.3.2017 г..
 */
public class Box<T> {
    private T item;

    public Box(){

    }

    public void add(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return this.item.getClass().getName() + ": " + this.item;
    }
}

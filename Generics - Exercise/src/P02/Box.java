package P02;

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

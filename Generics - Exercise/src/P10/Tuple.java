package P10;

public class Tuple<T, E> {
    private T item1;
    private E item2;
    //private V item3;

    public Tuple(T item1, E item2) {
        this.item1 = item1;
        this.item2 = item2;
        //this.item3 = item3;
    }

    public T getItem1() {
        return this.item1;
    }

    public E getItem2() {
        return this.item2;
    }

    @Override
    public String toString() {
        return this.item1 + " -> " + this.item2;
    }
}

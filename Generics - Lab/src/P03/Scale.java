package P03;

/**
 * Created by Andrian on 17.3.2017 г..
 */
public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int result =  this.left.compareTo(right);
        if(result == 0)
            return null;
        if(result == 1)
            return this.left;

        return this.right;
    }
}

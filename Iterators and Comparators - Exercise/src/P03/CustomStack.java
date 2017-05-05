package P03;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable {
    private List<Integer> stack;

    public CustomStack() {
        this.stack = new ArrayList<>();
    }

    public void push(Integer item) {
        this.stack.add(item);
    }

    public Integer pop() throws IllegalAccessException {
        if(this.stack.size() == 0)
            throw new IllegalAccessException("No elements");

        Integer element  = this.stack.get(this.stack.size() - 1);
        this.stack.remove(this.stack.size() - 1);

        return element;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        this.iterator().forEachRemaining(a -> sb.append(a).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {
        private int index;

        public CustomIterator() {
            this.index = stack.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public Integer next() {
            return stack.get(index--);
        }
    }
}

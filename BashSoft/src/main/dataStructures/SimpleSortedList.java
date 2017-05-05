package main.dataStructures;

import main.Interfaces.SimpleOrderedBag;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Andrian on 28.3.2017 г..
 */
public class SimpleSortedList<E extends Comparable<E>> implements SimpleOrderedBag<E> {
    private static final int DEFAULT_SIZE = 16;

    private E[] innerCollection;
    private int size;
    private Comparator<E> comparator;


    public SimpleSortedList(Class<E> type, Comparator<E> comparator, int capacity) {
        this.initializeCollection(type, capacity);
        this.comparator = comparator;
    }

    public SimpleSortedList(Class<E> type, int capacity) {
        this(type, Comparable::compareTo, capacity);
    }

    public SimpleSortedList(Class<E> type, Comparator<E> comparator) {
        this(type, comparator, DEFAULT_SIZE);
    }

    public SimpleSortedList(Class<E> type) {
        this(type, Comparable::compareTo, DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    private void initializeCollection(Class<E> type, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }

        this.innerCollection = (E[]) Array.newInstance(type, capacity);
    }

    private void rezise() {
        E[] newCollection = Arrays.copyOf(
                this.innerCollection,
                this.innerCollection.length + 2);
        this.innerCollection = newCollection;
    }

    private void multiResize(Collection<E> elements) {
        int newSize = this.innerCollection.length * 2;
        while (this.size + elements.size() >= newSize)
            newSize += 2;

        E[] newCollection = Arrays.copyOf(
                this.innerCollection,
                newSize);

        this.innerCollection = newCollection;
    }

    @Override
    public boolean remove(E element) {
        if(element == null)
            throw new IllegalArgumentException("Null passed");
        boolean hasBeenRemoved = false;

        for (int i = 0; i < this.size; i++) {
            if(this.innerCollection[i].compareTo(element) == 0) {
                this.innerCollection[i] = null;
                hasBeenRemoved = true;
                break;
            }
        }

        if(hasBeenRemoved) {
            for (int i = 0; i < this.size - 1; i++)
                this.innerCollection[i] = this.innerCollection[i + 1];

            this.innerCollection[this.size - 1] = null;
            this.size--;
        }
        return hasBeenRemoved;
    }

    @Override
    public int capacity() {
        return this.innerCollection.length;
    }

    @Override
    public void add(E element) {
        if(element == null) {
            throw new IllegalArgumentException("Null argument passed");
        }
        if (this.innerCollection.length == this.size + 1)
            this.rezise();

        this.innerCollection[this.size()] = element;
        this.size++;
        Arrays.sort(this.innerCollection, 0, this.size, this.comparator);
    }

    @Override
    public void addAll(Collection<E> elements) {
        if (this.size + elements.size() >= this.innerCollection.length) {
            this.multiResize(elements);
        }

        for (E element : elements) {
            if(element == null)
                throw new IllegalArgumentException("Null passed");
            this.innerCollection[this.size] = element;
            this.size++;
        }

        Arrays.sort(this.innerCollection, 0, this.size, this.comparator);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String joinWith(String joiner) {
        if(joiner == null)
            throw new IllegalArgumentException("Null joiner passed to function");

        StringBuilder output = new StringBuilder();
        for (E element : this) {
            output.append(element);
            output.append(joiner);
        }

        output.setLength(output.length() - joiner.length());
        return output.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size;
            }

            @Override
            public E next() {
                return innerCollection[this.index++];
            }
        };
    }

}

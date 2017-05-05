package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<E extends Comparable> extends ArrayList<E>{

    public E min() {
        E min = null;

        Iterator<E> elements = super.iterator();
        while(elements.hasNext()) {
            E element = elements.next();
            if(min == null || element.compareTo(min)  < 0)
                min = element;
        }

        return min;
    }

    public E max() {
        E max = null;

        Iterator<E> elements = super.iterator();
        while(elements.hasNext()) {
            E element = elements.next();
            if(max == null || element.compareTo(max) > 0)
                max = element;
        }

        return max;
    }
}

package P06;

import java.util.Comparator;

/**
 * Created by Andrian on 23.3.2017 г..
 */
public class PersonByNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int compVal = Integer.compare(o1.getName().length(), o2.getName().length());
        if (compVal != 0)
            return compVal;

        compVal = o1.getName().substring(0, 1).compareToIgnoreCase(o2.getName().substring(0, 1));
        return compVal;
    }
}

package P06;

import java.util.Comparator;

/**
 * Created by Andrian on 23.3.2017 г..
 */
public class PersonByAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

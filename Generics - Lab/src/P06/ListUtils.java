package P06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ListUtils {

    public static <T> T getMin(List<T> list) {
        listIsEmpty(list);

        Optional<T> first = list.stream().sorted().limit(1).findFirst();

        return first.get();
    }

    public static <T> T getMax(List<T> list) {
        listIsEmpty(list);
        Optional<T> first = list.stream().sorted(Collections.reverseOrder()).limit(1).findFirst();

        return first.get();
    }

    public static <T> List<Integer> getNullIndices(List<T> list) {
        List<Integer> nullIndexes = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == null)
                nullIndexes.add(i);
        }

        return nullIndexes;
    }

    public static <T> void flatten(List<T> destination, List<List<T>> source) {
        for (List<T> list : source) {
            for (T element : list) {
                destination.add(element);
            }
        }
    }

    public static <T> void addAll(List<T> destination , List<T> source) {
        destination.addAll(source);
    }

    private static <T> boolean listIsEmpty(List<T> list) {
        if(list.size() == 0)
            throw new IllegalArgumentException("Cannot pass an empty list");

        return false;
    }
}

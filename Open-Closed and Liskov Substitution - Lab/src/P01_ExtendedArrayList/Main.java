package P01_ExtendedArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        ExtendedArrayList<Integer> list = new ExtendedArrayList<>();
        list.add(1);
        list.add(5);
        list.add(9);
        System.out.println(list.min());
        System.out.println(list.max());
    }
}

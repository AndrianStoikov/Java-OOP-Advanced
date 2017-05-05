package P04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Integer[] input = Arrays.stream(Console.readLine().split("[, ]+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Lake lake = new Lake(input);

        Iterator<Integer> iterator = lake.iterator();

        StringBuilder sb =new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(", ");
        }

        System.out.println(sb.substring(0, sb.length() - 2));
    }
}

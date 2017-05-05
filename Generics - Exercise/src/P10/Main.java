package P10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = Console.readLine().split(" ");

        Tuple<String, String> tuple1 = new Tuple<>(strings[0] + " " + strings[1], strings[2]);
        System.out.println(tuple1);


        strings = Console.readLine().split(" ");
        String name = strings[0];
        Integer vals = Integer.valueOf(strings[1]);

        Tuple<String, Integer> tuple2 = new Tuple<>(name, vals);
        System.out.println(tuple2);

        strings = Console.readLine().split(" ");
        Integer integer = Integer.valueOf(strings[0]);
        Double aDouble = Double.valueOf(strings[1]);

        Tuple<Integer, Double> tuple3 = new Tuple<>(integer, aDouble);
        System.out.println(tuple3);
    }
}

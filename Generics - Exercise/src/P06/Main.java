package P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(Console.readLine());
        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            Double input = Double.valueOf(Console.readLine());
            box.add(input);
        }

        Double compareWith = Double.valueOf(Console.readLine());
        System.out.println(box.compare(compareWith));
    }
}

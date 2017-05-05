package P05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(Console.readLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String input = Console.readLine();
            box.add(input);
        }

        String compareWith = Console.readLine();
        System.out.println(box.compare(compareWith));
    }
}

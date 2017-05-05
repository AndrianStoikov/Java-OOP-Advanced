package P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(Console.readLine());
        for (int i = 0; i < n; i++) {
            Integer input = Integer.valueOf(Console.readLine());
            Box<Integer> box = new Box<>();
            box.add(input);
            System.out.println(box);
        }

    }
}

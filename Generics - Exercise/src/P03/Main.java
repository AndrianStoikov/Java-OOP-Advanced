package P03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(Console.readLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String input = Console.readLine();
            box.add(input);
        }

        String[] swapIndexes = Console.readLine().split(" ");
        int index1 = Integer.parseInt(swapIndexes[0]);
        int index2 = Integer.parseInt(swapIndexes[1]);
        box.swap(index1, index2);
        System.out.println(box);
    }
}

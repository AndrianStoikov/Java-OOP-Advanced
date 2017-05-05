package P04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Smartphone smartphone = new Smartphone();

        String[] input = Console.readLine().split(" ");
        for (String s : input) {
            smartphone.addNumber(s);
        }

        input = Console.readLine().split(" ");
        for (String s : input) {
            smartphone.addSite(s);
        }

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}

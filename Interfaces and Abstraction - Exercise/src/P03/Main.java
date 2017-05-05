package P03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String driver = Console.readLine();
        Ferrari ferrari = new Ferrari(driver);
        System.out.println(ferrari);
    }
}

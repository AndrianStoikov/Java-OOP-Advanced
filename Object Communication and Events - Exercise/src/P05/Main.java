package P05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String kingName = reader.readLine();

        King king = new King(kingName);

        Stream.of(reader.readLine().split("\\s+"))
                .map(RoyalGuard::new)
                .forEach(king::addGuard);

        Stream.of(reader.readLine().split("\\s+"))
                .map(Footman::new)
                .forEach(king::addFootman);

        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String cmd = tokens[0];

            switch (cmd) {
                case "Kill":
                    king.getSoldierAttacked(tokens[1]);
                    break;
                case "Attack":
                    king.getAttacked();
                    break;
            }
        }
    }
}
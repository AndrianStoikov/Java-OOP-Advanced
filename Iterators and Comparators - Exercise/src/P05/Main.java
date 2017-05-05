package P05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 23.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        while (true) {
            String[] input = Console.readLine().split("\\s+");
            if (input[0].equals("END"))
                break;

            Person person = new Person(
                    input[0],
                    Integer.parseInt(input[1]),
                    input[2]
            );

            persons.add(person);
        }

        int n = Integer.parseInt(Console.readLine());
        if(persons.size() <= n) {
            System.out.println("No matches");
            return;
        }

        Person person = persons.get(n);

        int matches = 0;
        int notEqual = 0;
        for (Person personComparable : persons) {
            if(person.compareTo(personComparable) == 0)
                matches++;
            else notEqual++;
        }

        if(matches == 0) {
            System.out.println("No matches");
            return;
        }

        System.out.printf("%s %s %s", matches, notEqual, persons.size());

    }
}

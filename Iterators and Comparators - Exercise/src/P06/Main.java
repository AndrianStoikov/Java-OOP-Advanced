package P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> stringComparedTree = new TreeSet<>(new PersonByNameComparator());
        TreeSet<Person> ageComparedTree = new TreeSet<>(new PersonByAgeComparator());

        int n = Integer.parseInt(Console.readLine());
        for (int i = 0; i < n; i++) {
            String[] parms = Console.readLine().split(" ");
            String name = parms[0];
            int age = Integer.parseInt(parms[1]);
            Person person = new Person(name, age);
            stringComparedTree.add(person);
            ageComparedTree.add(person);
        }

        for (Person person : stringComparedTree) {
            System.out.println(person);
        }

        for (Person person : ageComparedTree) {
            System.out.println(person);
        }
    }
}

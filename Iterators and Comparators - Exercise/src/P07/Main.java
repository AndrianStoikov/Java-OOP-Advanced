package P07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));


        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();
        int n = Integer.parseInt(Console.readLine());
        for (int i = 0; i < n; i++) {
            String[] arg = Console.readLine().split(" ");
            Person p = new Person(
                    arg[0],
                    Integer.parseInt(arg[1]));

            treeSet.add(p);
            hashSet.add(p);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}

package P07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));


        HashMap<String, Buyer> buyers = new HashMap<>();

        int n = Integer.parseInt(Console.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmdArgs = Console.readLine().split(" ");

            Buyer buyer = createBuyer(cmdArgs);
            buyers.put(cmdArgs[0], buyer);
        }


        while (true) {
            String name = Console.readLine();
            if (name.equals("End"))
                break;

            if (buyers.containsKey(name))
                buyers.get(name).buyFood();
        }

        int sum = 0;
        for (Buyer buyer : buyers.values()) {
            sum += buyer.getFood();
        }

        System.out.println(sum);
    }

    private static Buyer createBuyer(String[] cmdArgs) {
        if (cmdArgs.length == 4) {
            String name = cmdArgs[0];
            Integer age = Integer.valueOf(cmdArgs[1]);
            String id = cmdArgs[2];
            String birthDay = cmdArgs[3];
            return new Citizen(name, age, id, birthDay);
        }

        String name = cmdArgs[0];
        Integer age = Integer.valueOf(cmdArgs[1]);
        String group = cmdArgs[2];
        return new Rebel(name, age, group);
    }
}

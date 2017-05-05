package P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));


        List<BirthdayInhabitant> inhabitants = new ArrayList<>();
        while (true) {
            String[] cmdArgs = Console.readLine().split(" ");

            if ("End".equals(cmdArgs[0]))
                break;

            BirthdayInhabitant inhabitant = createInhabitant(cmdArgs);
            if(inhabitant != null)
                inhabitants.add(inhabitant);
        }

        String searchedYear = Console.readLine();
        for (BirthdayInhabitant inhabitant : inhabitants) {
            if(inhabitant.getBirthDay().endsWith(searchedYear))
                System.out.println(inhabitant.getBirthDay());
        }
    }

    private static BirthdayInhabitant createInhabitant(String[] cmdArgs) {
        switch (cmdArgs[0]) {
            case "Citizen": {
                String name = cmdArgs[1];
                Integer age = Integer.valueOf(cmdArgs[2]);
                String id = cmdArgs[3];
                String birthDay = cmdArgs[4];
                return new Citizen(id, name, age, birthDay);
            }
            case "Pet": {
                String name = cmdArgs[1];
                String birthDay = cmdArgs[2];
                return new Pet(name, birthDay);
            }
        }

        return null;
    }
}

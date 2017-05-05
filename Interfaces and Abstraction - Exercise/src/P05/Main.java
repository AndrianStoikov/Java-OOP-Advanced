package P05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));


        List<Inhabitable> inhabitants = new ArrayList<>();
        while(true) {
            String[] cmdArgs = Console.readLine().split(" ");

            if("End".equals(cmdArgs[0]))
                break;

            Inhabitable inhabitant = createInhabitant(cmdArgs);
            inhabitants.add(inhabitant);
        }

        String invalidID = Console.readLine();
        for (Inhabitable inhabitant : inhabitants) {
            if(inhabitant.getId().endsWith(invalidID))
                System.out.println(inhabitant.getId());
        }
    }

    private static Inhabitable createInhabitant(String[] cmdArgs) {
        if(cmdArgs.length == 3) {
            String name = cmdArgs[0];
            Integer age = Integer.valueOf(cmdArgs[1]);
            String id = cmdArgs[2];
            return new Citizen(id, name, age);
        }

        String model = cmdArgs[0];
        String id = cmdArgs[1];
        return new Robot(model, id);
    }
}

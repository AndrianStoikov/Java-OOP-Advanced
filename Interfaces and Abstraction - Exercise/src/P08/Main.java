package P08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Manager manager = new Manager();

    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] cmdArgs = Console.readLine().split(" ");
            if ("End".equals(cmdArgs[0]))
                break;

            try {
                createSoldier(cmdArgs);
            } catch (IllegalArgumentException e) {
                //Do nothing
            }

        }

        System.out.println(manager.printStatistics());
    }

    private static void createSoldier(String[] cmdArgs) throws IllegalArgumentException{
        switch (cmdArgs[0]) {
            case "Private": {
                String id = cmdArgs[1];
                String firstName = cmdArgs[2];
                String lastName = cmdArgs[3];
                Double salary = Double.valueOf(cmdArgs[4]);
                manager.createPrivate(id, firstName, lastName, salary);
            }
            break;
            case "Spy": {
                String id = cmdArgs[1];
                String firstName = cmdArgs[2];
                String lastName = cmdArgs[3];
                Integer codeNumber = Integer.valueOf(cmdArgs[4]);
                manager.createSpy(id, firstName, lastName, codeNumber);
            }
            break;
            case "LeutenantGeneral": {
                String id = cmdArgs[1];
                String firstName = cmdArgs[2];
                String lastName = cmdArgs[3];
                Double salary = Double.valueOf(cmdArgs[4]);
                manager.createGeneral(id, firstName, lastName, salary, cmdArgs);
            }
            break;
            case "Engineer": {
                String id = cmdArgs[1];
                String firstName = cmdArgs[2];
                String lastName = cmdArgs[3];
                Double salary = Double.valueOf(cmdArgs[4]);
                String corps = cmdArgs[5];
                manager.createEngineer(id, firstName, lastName, salary, corps, cmdArgs);
            }
            break;
            case "Commando": {
                String id = cmdArgs[1];
                String firstName = cmdArgs[2];
                String lastName = cmdArgs[3];
                Double salary = Double.valueOf(cmdArgs[4]);
                String corps = cmdArgs[5];
                manager.createCommando(id, firstName, lastName, salary, corps, cmdArgs);
            }
            break;
        }
    }
}

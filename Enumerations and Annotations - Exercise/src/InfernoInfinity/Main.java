package InfernoInfinity;

import InfernoInfinity.Annotations.Information;
import InfernoInfinity.Gems.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Weapon> weapons = new HashMap<>();
        List<String> list = new ArrayList<>();

        while (true) {
            String[] input = Console.readLine().split(";");
            if ("END".equals(input[0]))
                break;

            execCommand(input, weapons);
        }
    }

    private static void execCommand(String[] cmdArgs, HashMap<String, Weapon> weapons) {
        switch (cmdArgs[0]) {
            case "Create": {
                String type = cmdArgs[1];
                String name = cmdArgs[2];
                Weapon weapon = new Weapon(type, name);
                weapons.put(name, weapon);
            }
            break;
            case "Add": {
                String weaponName = cmdArgs[1];
                int index = Integer.parseInt(cmdArgs[2]);
                Socket socket = Socket.valueOf(cmdArgs[3]);
                weapons.get(weaponName).addGem(index, socket);
            }
            break;
            case "Remove": {
                String weaponName = cmdArgs[1];
                int index = Integer.parseInt(cmdArgs[2]);
                weapons.get(weaponName).removeGem(index);
            }
            break;
            case "Print": {
                String weaponName = cmdArgs[1];
                System.out.println(weapons.get(weaponName));
            }
            break;
            case "Compare": {
                String weapon1 = cmdArgs[1];
                String weapon2 = cmdArgs[2];
                if (weapons.get(weapon1).compareTo(weapons.get(weapon2)) > 0)
                    System.out.println(weapons.get(weapon1).toDetailedString());
                else
                    System.out.println(weapons.get(weapon2).toDetailedString());
            }
            break;
            case "Author": {
                Information information = Weapon.class.getAnnotation(Information.class);
                System.out.println("Author: " + information.author());
            } break;
            case "Revision": {
                Information information = Weapon.class.getAnnotation(Information.class);
                System.out.println("Revision: " + information.revision());
            } break;
            case "Description": {
                Information information = Weapon.class.getAnnotation(Information.class);
                System.out.println("Class description: " + information.description());
            } break;
            case "Reviewers": {
                Information information = Weapon.class.getAnnotation(Information.class);
                System.out.println("Reviewers: " + String.join(", ", information.reviewers()));
            } break;
        }
    }
}

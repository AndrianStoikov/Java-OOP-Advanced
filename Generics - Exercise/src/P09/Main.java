package P09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Interpreter<String> manager = new Interpreter<>();

    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = Console.readLine().split(" ");
            if ("END".equals(input[0]))
                break;

            execCommand(input);
        }
    }

    private static void execCommand(String[] cmdArgs) {
        switch (cmdArgs[0]) {
            case "Add": {
                manager.Add(cmdArgs[1]);
            }
            break;
            case "Remove": {
                manager.Remove(
                        Integer.parseInt(cmdArgs[1])
                );
            }
            break;
            case "Contains": {
                manager.Contains(cmdArgs[1]);
            }
            break;
            case "Swap": {
                manager.Swap(
                        Integer.parseInt(cmdArgs[1]),
                        Integer.parseInt(cmdArgs[2])
                );
            }
            break;
            case "Greater": {
                manager.Greater(cmdArgs[1]);
            }
            break;
            case "Max": {
                manager.Max();
            }
            break;
            case "Min": {
                manager.Min();
            }
            break;
            case "Sort": {
                manager.Sort();
            } break;
            case "Print": {
                manager.Print();
            } break;
        }
    }
}

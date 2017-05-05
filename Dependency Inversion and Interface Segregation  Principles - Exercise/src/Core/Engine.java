package Core;

import contracts.IBoatSimulatorDatabase;
import contracts.ICommandHandler;
import contracts.Runable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runable {
    private ICommandHandler commandHandler;
    private IBoatSimulatorDatabase database;

    public Engine(ICommandHandler commandHandler, IBoatSimulatorDatabase database) {
        this.database = database;
        this.commandHandler = commandHandler;
    }

    @Override
    public void run() throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        while (true) {
            String line = Console.readLine();
            List<String> tokens = Arrays.asList(line.split("\\\\"));
            String name = tokens.get(0);
            List<String> parameters = new ArrayList<>();
            for (int i = 1; i < tokens.size(); i++) {
                parameters.add(tokens.get(i));
            }


            if (line.equals("End")) {
                break;
            }
            try {
                String commandResult = this.commandHandler.ExecuteCommand(name, parameters);
                output.append(commandResult).append(System.lineSeparator());
            } catch (Exception ex) {
                output.append(ex.getMessage()).append(System.lineSeparator());
            }
        }

        System.out.println(output);
    }
}

package P03_DependencyInversion;

import P03_DependencyInversion.commands.CommandExecutor;
import P03_DependencyInversion.commands.Executor;
import P03_DependencyInversion.factories.CommandFactory;
import P03_DependencyInversion.factories.StrategyFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        PrimitiveCalculator calculator = new PrimitiveCalculator(StrategyFactory.create("+"));
        Executor executor = new CommandExecutor();
        while (true) {
            String[] cmdArgs = Console.readLine().split(" ");
            if("End".equals(cmdArgs[0]))
                return;

            System.out.print(executor.executeCommand(CommandFactory.create(cmdArgs, calculator)));
        }
    }
}

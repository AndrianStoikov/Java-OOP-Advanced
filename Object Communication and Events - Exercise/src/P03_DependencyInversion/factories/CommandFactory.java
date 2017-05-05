package P03_DependencyInversion.factories;

import P03_DependencyInversion.PrimitiveCalculator;
import P03_DependencyInversion.commands.CalculateCommand;
import P03_DependencyInversion.commands.ChangeModeCommand;
import P03_DependencyInversion.commands.Command;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class CommandFactory {
    public static Command create(String[] data, PrimitiveCalculator calculator) {
        if (data[0].equals("mode")) {
           return new ChangeModeCommand(data, calculator);
        } else {
           return new CalculateCommand(data, calculator);
        }
    }
}

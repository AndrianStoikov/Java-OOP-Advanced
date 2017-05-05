package P03_DependencyInversion.commands;

import P03_DependencyInversion.PrimitiveCalculator;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Command {
    String execute();
}

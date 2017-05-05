package P03_DependencyInversion.commands;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Executor {
    String executeCommand(Command command);
}

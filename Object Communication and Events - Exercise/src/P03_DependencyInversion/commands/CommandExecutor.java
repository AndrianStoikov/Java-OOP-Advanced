package P03_DependencyInversion.commands;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class CommandExecutor implements Executor {
    @Override
    public String executeCommand(Command command) {
        return command.execute();
    }
}

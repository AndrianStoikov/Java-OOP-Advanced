package main.io.commands;


import main.annotations.Alias;
import main.annotations.Inject;
import main.exceptions.InvalidInputException;
import main.io.IOManager;

@Alias("cdabs")
public class ChangeAbsolutePathCommand extends Command {

    @Inject
    private IOManager ioManager;

    public ChangeAbsolutePathCommand(String input,
                                     String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String absolutePath = data[1];
        this.ioManager.changeCurrentDirAbsolute(absolutePath);
    }
}

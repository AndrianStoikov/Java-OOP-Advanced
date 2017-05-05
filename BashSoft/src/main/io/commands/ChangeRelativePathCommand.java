package main.io.commands;


import main.annotations.Alias;
import main.annotations.Inject;
import main.exceptions.InvalidInputException;
import main.io.IOManager;

@Alias("cdrel")
public class ChangeRelativePathCommand extends Command {

    @Inject
    private IOManager ioManager;

    public ChangeRelativePathCommand(String input,
                                     String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String relativePath = data[1];
        this.ioManager.changeCurrentDirRelativePath(relativePath);
    }
}

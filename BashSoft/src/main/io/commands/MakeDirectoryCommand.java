package main.io.commands;

import main.annotations.Alias;
import main.annotations.Inject;
import main.exceptions.InvalidInputException;
import main.io.IOManager;

@Alias("mkdir")
public class MakeDirectoryCommand extends Command {

    @Inject
    private IOManager manager;

    public MakeDirectoryCommand(String input,
                                String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String folderName = data[1];
        this.manager.createDirectoryInCurrentFolder(folderName);
    }
}

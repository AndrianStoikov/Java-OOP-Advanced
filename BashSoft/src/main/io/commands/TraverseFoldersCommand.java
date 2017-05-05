package main.io.commands;

import main.annotations.Alias;
import main.annotations.Inject;
import main.exceptions.InvalidInputException;
import main.io.IOManager;


@Alias("ls")
public class TraverseFoldersCommand extends Command {

    @Inject
    private IOManager manager;

    public TraverseFoldersCommand(String input,
                                  String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1 && data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 1) {
            this.manager.traverseDirectory(0);
            return;
        }

        this.manager.traverseDirectory(Integer.valueOf(data[1]));
    }
}

package main.io.commands;

import main.annotations.Alias;
import main.annotations.Inject;
import main.exceptions.InvalidInputException;
import main.network.DownloadManager;

@Alias("downloadasynch")
public class DownloadAsynchCommand extends Command {

    @Inject
    private DownloadManager manager;

    public DownloadAsynchCommand(String input,
                                 String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileUrl = data[1];
        this.manager.downloadOnNewThread(fileUrl);
    }
}

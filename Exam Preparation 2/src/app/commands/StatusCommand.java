package app.commands;

import app.core.ProcessorSystem;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class StatusCommand extends BaseCommand {

    public StatusCommand(ProcessorSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        return this.getSystem().statusCommandExecuted();
    }
}

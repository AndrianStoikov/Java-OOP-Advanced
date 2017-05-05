package app.commands;

import app.core.ProcessorSystem;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public abstract class BaseCommand implements Executable {
    private ProcessorSystem system;

    protected BaseCommand(ProcessorSystem system) {
        this.system = system;
    }

    protected ProcessorSystem getSystem() {
        return this.system;
    }
}

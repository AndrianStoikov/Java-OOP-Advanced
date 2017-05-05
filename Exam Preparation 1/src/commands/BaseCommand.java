package commands;

import core.ManagementSystem;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public abstract class BaseCommand implements Executable {
    private ManagementSystem system;

    protected BaseCommand(ManagementSystem system) {
        this.system = system;
    }

    protected ManagementSystem getManagementSystem() {
        return this.system;
    }
}

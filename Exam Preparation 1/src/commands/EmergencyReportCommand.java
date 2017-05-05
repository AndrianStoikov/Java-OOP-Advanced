package commands;

import core.ManagementSystem;

/**
 * Created by Andrian on 19.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class EmergencyReportCommand extends BaseCommand {

    public EmergencyReportCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        return this.getManagementSystem().emergencyReport();
    }
}

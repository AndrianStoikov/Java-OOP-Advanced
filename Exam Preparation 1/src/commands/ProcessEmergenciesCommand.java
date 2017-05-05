package commands;

import annotations.InjectType;
import core.ManagementSystem;
import models.emergencies.Emergency;
import utils.RegistrationTime;

/**
 * Created by Andrian on 19.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ProcessEmergenciesCommand extends BaseCommand {

    @InjectType
    private String type;

    private Emergency emergency;
    private RegistrationTime registrationTime;

    public ProcessEmergenciesCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        ManagementSystem system = this.getManagementSystem();
        return system.processEmergencies(this.type);
    }

    private void setRegistrationTime(RegistrationTime time) {
        this.registrationTime = time;
    }
}

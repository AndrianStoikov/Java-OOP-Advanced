package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import models.emergencies.Emergency;
import models.emergencies.HealthEmergency;
import models.emergencies.PropertyEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by Andrian on 19.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class RegisterHealthEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] data;

    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterHealthEmergencyCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        ManagementSystem system = this.getManagementSystem();

        String description = this.data[0];
        EmergencyLevel level = EmergencyLevel.valueOf(this.data[1]);
        this.setRegistrationTime(new RegistrationTimeImpl(this.data[2]));
        int casulties = Integer.parseInt(this.data[3]);

        this.emergency = new HealthEmergency(description, level, this.registrationTime, casulties);
        return system.registerHealthEmergency(this.emergency);
    }

    private void setRegistrationTime(RegistrationTime time) {
        this.registrationTime = time;
    }
}

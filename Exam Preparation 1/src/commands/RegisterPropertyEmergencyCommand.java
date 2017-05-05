package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import models.emergencies.Emergency;
import models.emergencies.PropertyEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class RegisterPropertyEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] data;

    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterPropertyEmergencyCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        ManagementSystem system = this.getManagementSystem();

        String description = this.data[0];
        EmergencyLevel level = EmergencyLevel.valueOf(this.data[1]);
        this.registrationTime = new RegistrationTimeImpl(this.data[2]);
        int damage = Integer.parseInt(this.data[3]);

        this.emergency = new PropertyEmergency(description, level, this.registrationTime, damage);
        return system.registerPropertyEmergency(this.emergency);
    }

    private void setRegistrationTime(RegistrationTime time) {
        this.registrationTime = time;
    }
}

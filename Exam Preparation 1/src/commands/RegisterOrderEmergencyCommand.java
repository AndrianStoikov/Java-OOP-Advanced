package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import enums.Status;
import models.emergencies.Emergency;
import models.emergencies.OrderEmergency;
import models.emergencies.PropertyEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by Andrian on 19.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class RegisterOrderEmergencyCommand extends BaseCommand {

    private static final String NON_SPECIAL = "NON_SPECIAL";
    @InjectArgs
    private String[] data;

    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterOrderEmergencyCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        ManagementSystem system = this.getManagementSystem();

        String description = this.data[0];
        EmergencyLevel level = EmergencyLevel.valueOf(this.data[1]);
        this.registrationTime = new RegistrationTimeImpl(this.data[2]);
        String statusString = this.data[3];

        Status status;
        if(statusString.equals("Non-Special"))
            status = Status.valueOf(NON_SPECIAL);
        else
            status = Status.valueOf(statusString.toUpperCase());

        this.emergency = new OrderEmergency(description, level, this.registrationTime, status);
        return system.registerOrderEmergency(this.emergency);
    }

    private void setRegistrationTime(RegistrationTime time) {
        this.registrationTime = time;
    }
}

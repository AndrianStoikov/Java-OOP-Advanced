package models.emergencies;

import enums.EmergencyLevel;
import enums.Status;
import utils.RegistrationTime;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class OrderEmergency extends BaseEmergency {
    private Status status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel,
                          RegistrationTime registrationTime, Status status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public int getValue() {
        if (status == Status.SPECIAL)
            return 1;

        return 0;
    }
}

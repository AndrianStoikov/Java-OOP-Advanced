package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class HealthEmergency extends BaseEmergency {
    private int casulties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel,
                           RegistrationTime registrationTime, int casulties) {
        super(description, emergencyLevel, registrationTime);
        this.casulties = casulties;
    }

    @Override
    public int getValue() {
        return this.casulties;
    }
}

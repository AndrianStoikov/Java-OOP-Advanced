package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PublicHealthEmergency extends BaseEmergency {
    private int casualties;

    public PublicHealthEmergency(String description, EmergencyLevel emergencyLevel,
                                 RegistrationTime registrationTime, int casualties) {
        super(description, emergencyLevel, registrationTime);
        this.casualties = casualties;
    }
}

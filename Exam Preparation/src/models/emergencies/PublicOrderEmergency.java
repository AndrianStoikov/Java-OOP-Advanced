package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PublicOrderEmergency extends BaseEmergency {
    private boolean isSpecialCase;

    public PublicOrderEmergency(String description, EmergencyLevel emergencyLevel,
                                RegistrationTime registrationTime, boolean isSpecialCase) {
        super(description, emergencyLevel, registrationTime);
        this.isSpecialCase = isSpecialCase;
    }
}

package factories;

import enums.EmergencyLevel;
import models.emergencies.PublicOrderEmergency;
import utils.RegistrationTime;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PublicOrderEmergencyFactory {
    public static PublicOrderEmergency create(String description, String emergencyLevel,
                                              String registrationTime, String status) {
        EmergencyLevel level = EmergencyLevel.valueOf(emergencyLevel);
        RegistrationTime time = new RegistrationTime(registrationTime);
        boolean isSpecialCase = Boolean.parseBoolean(status);
        return new PublicOrderEmergency(description, level, time, isSpecialCase);
    }
}

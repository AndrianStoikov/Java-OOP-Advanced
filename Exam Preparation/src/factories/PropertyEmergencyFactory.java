package factories;

import enums.EmergencyLevel;
import models.emergencies.PublicPropertyEmergency;
import utils.RegistrationTime;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PropertyEmergencyFactory {
    public static PublicPropertyEmergency create(String description, String emergencyLevel,
                                                 String registrationTime, String damage) {
        EmergencyLevel level = EmergencyLevel.valueOf(emergencyLevel);
        RegistrationTime time = new RegistrationTime(registrationTime);
        int dmg = Integer.parseInt(damage);
        return new PublicPropertyEmergency(description, level, time, dmg);
    }
}

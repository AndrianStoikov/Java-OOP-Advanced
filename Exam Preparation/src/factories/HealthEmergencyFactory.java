package factories;

import enums.EmergencyLevel;
import models.emergencies.PublicHealthEmergency;
import utils.RegistrationTime;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class HealthEmergencyFactory {
    public static PublicHealthEmergency create(String description, String emergencyLevel,
                                               String registrationTime, String casulties) {

        EmergencyLevel level = EmergencyLevel.valueOf(emergencyLevel);
        RegistrationTime time = new RegistrationTime(registrationTime);
        int cas = Integer.parseInt(casulties);
        return new PublicHealthEmergency(description, level, time, cas);
    }
}

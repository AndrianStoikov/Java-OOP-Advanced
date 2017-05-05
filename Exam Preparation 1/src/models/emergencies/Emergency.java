package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Emergency {
    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();

    int getValue();
}

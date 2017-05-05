package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PublicPropertyEmergency extends BaseEmergency {
    private int damage;

    public PublicPropertyEmergency(String description, EmergencyLevel emergencyLevel,
                                   RegistrationTime registrationTime, int damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }
}

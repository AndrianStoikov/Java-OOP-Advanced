package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PropertyEmergency extends BaseEmergency {
    private int propertyDamage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel,
                             RegistrationTime registrationTime, int propertyDamage) {
        super(description, emergencyLevel, registrationTime);
        this.propertyDamage = propertyDamage;
    }

    @Override
    public int getValue() {
        return this.propertyDamage;
    }
}

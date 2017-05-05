package core;

import annotations.Inject;
import data.IDataBase;
import factories.*;
import models.emergencies.PublicHealthEmergency;
import models.emergencies.PublicOrderEmergency;
import models.emergencies.PublicPropertyEmergency;
import models.emergencyCenters.FiremanServiceCenter;
import models.emergencyCenters.MedicalServiceCenter;
import models.emergencyCenters.PoliceServiceCenter;

import java.util.List;

public class EmergencyManagementSystem implements ManagementSystem {

    private static final String EMERGENCY_REGISTERED_MESSAGE = "Registered %s of level %s at %s";
    private static final String PUBLIC_PROPERTY_EMERGENCY_STRING = "Public Property Emergency";
    private static final String PUBLIC_HEALTH_EMERGENCY_STRING = "Public Health Emergency";
    private static final String PUBLIC_ORDER_EMERGENCY_STRING = "Public Order Emergency";
    private static final String FIRE_EMERGENCY_CENTER_STRING = "Fire";
    private static final String MEDICAL__EMERGENCY_CENTER_STRING = "Medical";
    private static final String POLICE__EMERGENCY_CENTER_STRING = "Police";

    @Inject
    private IDataBase dataBase;

    public EmergencyManagementSystem() {

    }

    @Override
    public String registerPropertyEmergency(String[] data) {
        String description = data[0];
        String emergencyLevel = data[1];
        String registrationTime = data[2];
        String damage = data[3];
        PublicPropertyEmergency emergency =
                PropertyEmergencyFactory.create(description, emergencyLevel, registrationTime, damage);
        this.dataBase.getRegisterCollection().enqueueEmergency(emergency);

        return String.format(EMERGENCY_REGISTERED_MESSAGE,
                PUBLIC_PROPERTY_EMERGENCY_STRING, emergencyLevel, registrationTime);
    }

    @Override
    public String registerHealthEmergency(String[] data) {
        String description = data[0];
        String emergencyLevel = data[1];
        String registrationTime = data[2];
        String casulties = data[3];

        PublicHealthEmergency emergency =
                HealthEmergencyFactory.create(description, emergencyLevel, registrationTime, casulties);
        this.dataBase.getRegisterCollection().enqueueEmergency(emergency);

        return String.format(EMERGENCY_REGISTERED_MESSAGE,
                PUBLIC_HEALTH_EMERGENCY_STRING, emergencyLevel, registrationTime);
    }

    @Override
    public String registerOrderEmergency(String[] data) {
        String description = data[0];
        String emergencyLevel = data[1];
        String registrationTime = data[2];
        String status = data[3];

        PublicOrderEmergency emergency =
                PublicOrderEmergencyFactory.create(description, emergencyLevel, registrationTime, status);
        this.dataBase.getRegisterCollection().enqueueEmergency(emergency);

        return String.format(EMERGENCY_REGISTERED_MESSAGE,
                PUBLIC_ORDER_EMERGENCY_STRING, emergencyLevel, registrationTime);
    }

    @Override
    public String registerFireServiceCenter(String[] data) {
        String name = data[0];
        String amountOfEmergencies = data[1];
        FiremanServiceCenter center = FireServiceCenterFactory.create(name, amountOfEmergencies);
        this.dataBase.addFireEmergencyCenter(center);

        return String.format("Registered %s Service Emergency center – %s.", FIRE_EMERGENCY_CENTER_STRING, name);
    }

    @Override
    public String registerMedicalServiceCenter(String[] data) {
        String name = data[0];
        String amountOfEmergencies = data[1];
        MedicalServiceCenter center = MedicalServiceCenterFactory.create(name, amountOfEmergencies);
        this.dataBase.addMedicalEmergencyCenter(center);

        return String.format("Registered %s Service Emergency center – %s.", MEDICAL__EMERGENCY_CENTER_STRING, name);
    }

    @Override
    public String registerPoliceServiceCenter(String[] data) {
        String name = data[0];
        String amountOfEmergencies = data[1];
        PoliceServiceCenter center = PoliceServiceCenterFactory.create(name, amountOfEmergencies);
        this.dataBase.addPoliceEmergencyCenter(center);

        return String.format("Registered %s Service Emergency center – %s.", POLICE__EMERGENCY_CENTER_STRING, name);
    }

    @Override
    public String processEmergencies(String[] data) {
        String type = data[0];
        switch (type) {
            case "Property": {

            }
        }
        return null;
    }

    @Override
    public String emergencyReport(String[] data) {
        return null;
    }
}

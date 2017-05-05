package core;

import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface ManagementSystem {
    String registerPropertyEmergency(Emergency emergency);

    String registerHealthEmergency(Emergency emergency);

    String registerOrderEmergency(Emergency emergency);

    String registerFireServiceCenter(EmergencyCenter center);

    String registerMedicalServiceCenter(EmergencyCenter center);

    String registerPoliceServiceCenter(EmergencyCenter center);

    String processEmergencies(String type);

    String emergencyReport();
}

package factories;

import models.emergencyCenters.MedicalServiceCenter;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class MedicalServiceCenterFactory {
    public static MedicalServiceCenter create(String name, String amountOfEmergencies) {
        int emergencies = Integer.parseInt(amountOfEmergencies);

        return new MedicalServiceCenter(name, emergencies);
    }
}

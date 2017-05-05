package factories;

import models.emergencyCenters.FiremanServiceCenter;
import models.emergencyCenters.PoliceServiceCenter;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PoliceServiceCenterFactory {
    public static PoliceServiceCenter create(String name, String amountOfEmergencies) {
        int emergencies = Integer.parseInt(amountOfEmergencies);

        return new PoliceServiceCenter(name, emergencies);
    }
}

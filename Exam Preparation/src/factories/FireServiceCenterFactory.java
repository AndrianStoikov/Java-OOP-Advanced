package factories;

import models.emergencyCenters.FiremanServiceCenter;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class FireServiceCenterFactory {
    public static FiremanServiceCenter create(String name, String amountOfEmergencies) {
        int emergencies = Integer.parseInt(amountOfEmergencies);

        return new FiremanServiceCenter(name, emergencies);
    }
}

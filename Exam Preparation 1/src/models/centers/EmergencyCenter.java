package models.centers;

import models.emergencies.Emergency;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface EmergencyCenter {
    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();

    void processEmergency(Emergency emergency);
}

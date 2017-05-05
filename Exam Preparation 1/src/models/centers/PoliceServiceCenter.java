package models.centers;

import models.emergencies.Emergency;

/**
 * Created by Andrian on 19.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PoliceServiceCenter extends BaseEmergencyCenter {
    private int proccesedEmergencies;

    public PoliceServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
    }

    @Override
    public Boolean isForRetirement() {
        return this.proccesedEmergencies == this.getAmountOfMaximumEmergencies();
    }

    @Override
    public void processEmergency(Emergency emergency) {
        this.proccesedEmergencies++;
    }
}

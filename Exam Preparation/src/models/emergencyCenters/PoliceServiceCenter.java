package models.emergencyCenters;

import models.emergencies.PublicOrderEmergency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class PoliceServiceCenter extends BaseEmergencyCenter {
    private List<PublicOrderEmergency> emergencies;

    public PoliceServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
        this.emergencies = new ArrayList<>();
    }

    @Override
    public Boolean isForRetirement() {
        return this.emergencies.size() == this.getAmountOfMaximumEmergencies();
    }

    public void processEmergency(PublicOrderEmergency emergency) {
        this.emergencies.add(emergency);
    }
}

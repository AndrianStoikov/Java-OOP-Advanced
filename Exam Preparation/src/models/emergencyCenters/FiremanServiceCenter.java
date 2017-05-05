package models.emergencyCenters;

import models.emergencies.PublicPropertyEmergency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class FiremanServiceCenter extends BaseEmergencyCenter {
    private List<PublicPropertyEmergency> emergencies;

    public FiremanServiceCenter(String name,
                                Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
        this.emergencies = new ArrayList<>();
    }

    @Override
    public Boolean isForRetirement() {
        return this.emergencies.size() == this.getAmountOfMaximumEmergencies();
    }

    public void processEmergency(PublicPropertyEmergency emergency) {
        this.emergencies.add(emergency);
    }
}

package models.emergencyCenters;

import models.emergencies.PublicHealthEmergency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class MedicalServiceCenter extends BaseEmergencyCenter {
    private List<PublicHealthEmergency> emergencies;

    public MedicalServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
        this.emergencies = new ArrayList<>();
    }

    @Override
    public Boolean isForRetirement() {
        return this.emergencies.size() == this.getAmountOfMaximumEmergencies();
    }

    public void processEmergency(PublicHealthEmergency emergency) {
        this.emergencies.add(emergency);
    }
}

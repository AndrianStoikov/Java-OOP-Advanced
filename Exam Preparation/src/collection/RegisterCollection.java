package collection;

import models.emergencies.BaseEmergency;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface RegisterCollection {
    void enqueueEmergency(BaseEmergency emergency);

    BaseEmergency dequeueEmergency();

    BaseEmergency peekEmergency();

    Boolean isEmpty();

    int size();
}

package collection;

import models.emergencies.Emergency;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Register<T> {
    void enqueueEmergency(T emergency);

    T dequeueEmergency();

    T peekEmergency();

    Boolean isEmpty();

    int size();
}

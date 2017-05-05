package P04_WorkForce.models.subjects;

import P04_WorkForce.models.observers.JobCollection;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Subject {
    void update();

    void attachToCollection(JobCollection collection);

    void notifyAllCollections();
}

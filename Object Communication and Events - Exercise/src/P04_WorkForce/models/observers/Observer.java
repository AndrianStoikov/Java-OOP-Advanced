package P04_WorkForce.models.observers;

import P04_WorkForce.models.subjects.Job;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Observer {
    void notifyForChangeIn(Job job);
}

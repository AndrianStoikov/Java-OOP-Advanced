package P04_WorkForce.models.subjects;

import P04_WorkForce.contracts.Nameable;
import P04_WorkForce.models.NameableEmployee;
import P04_WorkForce.models.observers.JobCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Job implements Subject, Nameable{
    private String name;
    private NameableEmployee employee;
    private List<JobCollection> collectionAddedIn;
    private int requiredWorkingHours;

    public Job(String name, NameableEmployee employee, int requiredWorkingHours) {
        this.name = name;
        this.employee = employee;
        this.requiredWorkingHours = requiredWorkingHours;
        this.collectionAddedIn = new ArrayList<>();
    }

    @Override
    public void update() {
        this.requiredWorkingHours -= this.employee.getWorkHours();
        if(this.requiredWorkingHours <= 0) {
            this.notifyAllCollections();
        }
    }

    @Override
    public void attachToCollection(JobCollection collection) {
        this.collectionAddedIn.add(collection);
    }

    @Override
    public void notifyAllCollections() {
        for (JobCollection collection : this.collectionAddedIn) {
            collection.notifyForChangeIn(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.name, this.requiredWorkingHours);
    }

    @Override
    public String getName() {
        return this.name;
    }
}

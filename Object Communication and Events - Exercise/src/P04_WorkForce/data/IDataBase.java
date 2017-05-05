package P04_WorkForce.data;

import P04_WorkForce.models.Employee;
import P04_WorkForce.models.NameableEmployee;
import P04_WorkForce.models.observers.JobCollection;
import P04_WorkForce.models.subjects.Job;

import java.util.Map;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface IDataBase {
    JobCollection getJobs();

    void addJob(Job job);

    void addEmployee(NameableEmployee employee);

    NameableEmployee getEmployee(String name);
}

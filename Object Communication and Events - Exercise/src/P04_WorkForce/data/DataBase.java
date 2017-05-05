package P04_WorkForce.data;

import P04_WorkForce.models.Employee;
import P04_WorkForce.models.NameableEmployee;
import P04_WorkForce.models.observers.JobCollection;
import P04_WorkForce.models.subjects.Job;
import P04_WorkForce.writers.ConsoleWriter;
import P04_WorkForce.writers.Writer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class DataBase implements IDataBase {
    private JobCollection jobs;
    private Map<String, NameableEmployee> employees;

    public DataBase(Writer writer) {
        this.jobs = new JobCollection("Collection", writer);
        this.employees = new HashMap<>();
    }

    @Override
    public JobCollection getJobs() {
        return this.jobs;
    }

    @Override
    public void addJob(Job job) {
        this.jobs.addJob(job);
    }

    @Override
    public void addEmployee(NameableEmployee employee) {
        this.employees.put(employee.getName(), employee);
    }

    @Override
    public NameableEmployee getEmployee(String name) {
        return this.employees.get(name);
    }
}

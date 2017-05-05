package P04_WorkForce.models.observers;

import P04_WorkForce.models.subjects.Job;
import P04_WorkForce.writers.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class JobCollection implements Observer {
    private String name;
    private List<Job> jobs;
    private Writer writer;

    public JobCollection(String name, Writer writer) {
        this.name = name;
        this.jobs = new ArrayList<>();
        this.writer = writer;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
        job.attachToCollection(this);
    }

    private void removeJob(Job job) {
        this.jobs.set(this.jobs.indexOf(job), null);
    }

    @Override
    public void notifyForChangeIn(Job job) {
        this.removeJob(job);
        this.writer.printLn(String.format("Job %s done!", job.getName()));
    }

    public void passWeek() {
        for (Job job : this.jobs) {
            if(job == null)
                continue;

            job.update();
        }
    }

    public void getStatus() {
        for (Job job : this.jobs) {
            if(job == null)
                continue;
            this.writer.printLn(job.toString());
        }
    }
}

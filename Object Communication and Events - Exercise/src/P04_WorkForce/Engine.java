package P04_WorkForce;

import P04_WorkForce.data.IDataBase;
import P04_WorkForce.models.NameableEmployee;
import P04_WorkForce.models.PartTimeEmployee;
import P04_WorkForce.models.StandartEmployee;
import P04_WorkForce.models.subjects.Job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Engine {
    private IDataBase dataBase;

    public Engine(IDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void run() throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] cmdArgs = Console.readLine().split(" ");
            if("End".equals(cmdArgs[0]))
                return;

            execCommand(cmdArgs ,Console);
        }
    }

    private void execCommand(String[] cmdArgs, BufferedReader Console) {
        String command = cmdArgs[0];
        switch (command) {
            case "Job": {
                String nameOfJob = cmdArgs[1];
                int workingHours = Integer.parseInt(cmdArgs[2]);
                String employeeName = cmdArgs[3];
                NameableEmployee employee = dataBase.getEmployee(employeeName);
                Job job = new Job(nameOfJob, employee, workingHours);
                dataBase.addJob(job);
            } break;
            case "StandartEmployee": {
                String name = cmdArgs[1];
                NameableEmployee employee = new StandartEmployee(name);
                this.dataBase.addEmployee(employee);
            } break;
            case "PartTimeEmployee": {
                String name = cmdArgs[1];
                NameableEmployee employee = new PartTimeEmployee(name);
                this.dataBase.addEmployee(employee);
            } break;
            case "Pass": {
                this.dataBase.getJobs().passWeek();
            } break;
            case "Status": {
                this.dataBase.getJobs().getStatus();
            } break;
        }
    }
}

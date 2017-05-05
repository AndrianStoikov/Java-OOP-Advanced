package main.io.commands;

import main.annotations.Alias;
import main.annotations.Inject;
import main.exceptions.InvalidInputException;
import main.repository.StudentsRepository;

@Alias("show")
public class ShowCourseCommand extends Command {

    @Inject
    private StudentsRepository repository;

    public ShowCourseCommand(String input,
                             String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2 && data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 2) {
            String courseName = data[1];
            this.repository.getStudentsByCourse(courseName);
            return;
        }

        String courseName = data[1];
        String userName = data[2];
        this.repository.getStudentMarkInCourse(courseName, userName);

    }
}

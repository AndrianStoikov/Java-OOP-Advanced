package main.Interfaces;

import java.util.Map;

/**
 * Created by Andrian on 28.3.2017 г..
 */
public interface Course extends Comparable<Course>{
    String getName();

    Map<String, Student> getStudentsByName();

    void enrollStudent(Student student);
}

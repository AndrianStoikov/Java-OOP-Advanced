package main.Interfaces;

import java.util.Map;

/**
 * Created by Andrian on 28.3.2017 г..
 */
public interface Student extends Comparable<Student>{
    String getUserName();

    Map<String, Course> getEnrolledCourses();

    Map<String, Double> getMarksByCourseName();

    void enrollInCourse(Course course);

    void setMarkOnCourse(String courseName, int[] scores);

    String getMarkForCourse(String courseName);
}

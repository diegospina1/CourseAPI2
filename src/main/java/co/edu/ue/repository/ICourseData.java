package co.edu.ue.repository;

import co.edu.ue.model.Course;
import co.edu.ue.model.DTOCourse;

import java.util.List;

public interface ICourseData {


    List<Course> getListCourses();
    Course getCourseByName(String name);
    Course getCourseById(Long id);
}

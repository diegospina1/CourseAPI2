package co.edu.ue.service;


import co.edu.ue.model.Course;
import co.edu.ue.model.DTOCourse;

import java.util.List;

public interface ICourseService {

    //se declara metodos o constantes
    List<Course> allDataList();

    Course courseById(Long id);

    Course updateCourse(DTOCourse dtoCourse);

    List<Course> addCourse(Course course);

    List<Course> coursesSale();

    List<Course> coursesIVA();

    Course getByName(String name);

    Course findInJsonByName(String name);

    Course findInJsonById(Long id);

    List<Course> findInJsonAll();
}

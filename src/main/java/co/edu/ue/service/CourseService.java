package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.ue.model.DTOCourse;
import co.edu.ue.repository.CourseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.edu.ue.model.Course;
import co.edu.ue.repository.CourseData;


@Service
public class CourseService implements ICourseService{

    @Value("${iva}")
    double IVA;
    @Value("${desc}")
    double DESC;

    private CourseData data;

    @Autowired
    private CourseJson courseJson;
    //inyección metodo setter
//    @Autowired
//    public void setData(CourseRepository data) {
//        this.data = data;
//    }
    //inyeccion por constructor, no hay necesidad de colocar @autowired
    public CourseService(CourseData data) {
        this.data = data;
    }


    @Override
    public List<Course> allDataList() {
        return data.getListCourses();
    }
    @Override
    public Course courseById(Long id) {
        return data.getCourseById(id);
    }
    @Override
    public Course updateCourse(DTOCourse dtoCourse) {
        return data.putCourse(dtoCourse);
    }
    @Override
    public List<Course> addCourse(Course course) {
        return data.postCourse(course);
    }
    @Override
    public List<Course> coursesSale() {
        return data.getListCourses().stream().map(
                c -> {
                    double value = (c.getPrice() - (c.getPrice() * DESC));
                    return new Course(c.getId(), c.getName(), c.getDescription(), (long) value);
                }).collect(Collectors.toList());
    }
    @Override
    public List<Course> coursesIVA() {
        return data.getListCourses().stream().map(
                c -> {
                    double value = (c.getPrice() + (c.getPrice() * IVA));
                    c.setPrice((long) value);
                    return c;
                }).collect(Collectors.toList());
    }
    @Override
    public Course getByName(String name){
        return data.getCourseByName(name);
    }

    @Override
    public Course findInJsonByName(String name){
        return courseJson.getCourseByName(name);
    }

    @Override
    public Course findInJsonById(Long id){
        return courseJson.getCourseById(id);
    }

    @Override
    public List<Course> findInJsonAll(){
        return courseJson.getListCourses();
    }

}

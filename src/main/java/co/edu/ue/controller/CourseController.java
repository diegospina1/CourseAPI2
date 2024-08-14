package co.edu.ue.controller;

import java.util.List;

import co.edu.ue.model.DTOCourse;
import co.edu.ue.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import co.edu.ue.model.Course;
import co.edu.ue.service.CourseService;


@RestController
@RequestMapping(value = "/courses")
public class CourseController {
    @Autowired
    ICourseService service;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> allCourse() {
        return service.allDataList();
    }

    @GetMapping(value = "/discount", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> discount() {
        return service.coursesSale();
    }

    @GetMapping(value = "/taxes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> taxes() {
        return service.coursesIVA();
    }

    @GetMapping(value = "/course/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course findById(@PathVariable("id") Long id) {
        return service.courseById(id);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> addCourse(@RequestBody Course course) {
        return service.addCourse(course);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCourse(@PathVariable("id") Long id) {
        Course course = service.courseById(id);
        course.disable();
        return "Course deleted successfully.";
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course updateCourse(@RequestBody DTOCourse datosCourse) {
        return service.updateCourse(datosCourse);
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getByName(@PathVariable("name") String name) {
         return service.getByName(name);
    }

    //LEYENDO ARCHIVOS LOCALES
    @GetMapping(value = "/json/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getByNameInJson(@PathVariable("name") String name) {
        return service.findInJsonByName(name);
    }

    @GetMapping(value = "/json/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> allCoursesInJson() {
        return service.findInJsonAll();
    }

    @GetMapping(value = "/json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course findByIdInJson(@PathVariable("id") Long id) {
        return service.findInJsonById(id);
    }





}

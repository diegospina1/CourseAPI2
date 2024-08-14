package co.edu.ue.repository;

import co.edu.ue.model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CourseJson implements ICourseData{

    private List<Course> listCourses;

    public CourseJson() {
        try{
            Resource path = new ClassPathResource("/json/data.json");
            ObjectMapper mapper = new ObjectMapper();
            Course[] courses = mapper.readValue(path.getInputStream(), Course[].class);
            this.listCourses = new ArrayList<>(Arrays.asList(courses));
        } catch (IOException e) {
                e.printStackTrace();
                this.listCourses = new ArrayList<>();
        }
    }

    @Override
    public List<Course> getListCourses() {
        return this.listCourses;
    }

    @Override
    public Course getCourseByName(String name) {
        return this.listCourses.stream()
                .filter(course -> course.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow();
    }

    @Override
    public Course getCourseById(Long id) {
        return this.listCourses.stream().filter(course -> course.getId().equals(id))
                .findFirst().orElseThrow();
    }



}

package co.edu.ue.project;

import co.edu.ue.repository.CourseJson;
import co.edu.ue.repository.ICourseData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    @Bean
    @Primary
    ICourseData dataJson(){
        return new CourseJson();
    }
}

package kh.edu.cstad.customer.qualifybean;

import kh.edu.cstad.customer.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.UUID;

@Configuration
// studentBeanConfig
public class StudentBeanConfig {

    @Bean
    // theara
    public Student theara() {
        Student student = new Student();
        student.setUuid(UUID.randomUUID().toString());
        student.setFullName("Theara 1");
        student.setScore(90.0);

        return student;
    }

    @Bean
    // theara2
    public Student theara2() {
        Student student = new Student();
        student.setUuid(UUID.randomUUID().toString());
        student.setFullName("Thera 2");
        student.setScore(90.0);

        return student;
    }

}

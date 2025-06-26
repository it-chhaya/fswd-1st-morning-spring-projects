package kh.edu.cstad.customer.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
//@Service
//@Repository
public class AnnotationBasedConfig {

    public Student getStudent() {

        Student student = new Student();
        student.setUuid(UUID.randomUUID().toString());
        student.setFullName("Tola");
        student.setScore(90.0);

        return student;
    }

}

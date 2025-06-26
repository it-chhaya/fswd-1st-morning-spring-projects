package kh.edu.cstad.customer.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class InMemoryDatabase {

    private List<Student> students;

    public void insert(Student newStudent) {
        students.add(newStudent);
    }

    @Bean
    public List<Student> getStudents() {
        students = new ArrayList<>();

        Student st1 = new Student();
        st1.setUuid(UUID.randomUUID().toString());
        st1.setFullName("John Doe");
        st1.setScore(90.00);

        Student st2 = new Student();
        st2.setUuid(UUID.randomUUID().toString());
        st2.setFullName("John Wick");
        st2.setScore(80.00);

        students.add(st1);
        students.add(st2);

        return students;
    }

}

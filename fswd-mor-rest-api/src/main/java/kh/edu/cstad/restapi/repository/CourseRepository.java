package kh.edu.cstad.restapi.repository;

import kh.edu.cstad.restapi.domain.Course;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Setter
@Getter
public class CourseRepository {

    private List<Course> courses;

    public CourseRepository() {

        courses = new ArrayList<>();

        courses.add(Course.builder()
                .id(UUID.randomUUID().toString())
                .code("ISTAD-001")
                .title("Spring Framework")
                .price(100.00)
                .status(true)
                .build());
        courses.add(Course.builder()
                .id(UUID.randomUUID().toString())
                .code("ISTAD-002")
                .title("NextJS")
                .price(80.00)
                .status(false)
                .build());
    }
}

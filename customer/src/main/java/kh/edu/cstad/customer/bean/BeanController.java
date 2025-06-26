package kh.edu.cstad.customer.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BeanController {

    // Declare dependency
    // private final List<Student> students;
    private final InMemoryDatabase inMemoryDatabase;

    @GetMapping("/new")
    public void addStudent() {
        Student student = new Student();
        student.setUuid(UUID.randomUUID().toString());
        student.setFullName("User-" + student.getUuid());
        student.setScore(100.00);
        inMemoryDatabase.insert(student);
    }

    @GetMapping("/api/students")
    public List<Student> getStudents() {
        return inMemoryDatabase.getStudents();
    }

}

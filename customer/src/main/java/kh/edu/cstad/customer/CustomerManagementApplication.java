package kh.edu.cstad.customer;

import kh.edu.cstad.customer.bean.AnnotationBasedConfig;
import kh.edu.cstad.customer.bean.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CustomerManagementApplication implements
		CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}

	// Define dependencies (required)
	private final AnnotationBasedConfig config;
	private final List<Student> students;

	private final Student theara;

	// DI by Constructor
//	public CustomerManagementApplication(AnnotationBasedConfig config,
//										 List<Student> students,
//										 @Qualifier("theara2") Student student) {
//		this.config = config;
//		this.students = students;
//		this.student = student;
//	}

	// DI by Setter
//	@Autowired
//	public void setConfig(AnnotationBasedConfig config) {
//		this.config = config;
//	}




//	@Autowired
//	@Qualifier("theara2")
//	public void setStudent(Student student) {
//		this.student = student;
//	}

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private Integer appPort;

    @Value("${app.my-key:secret}")
    private String myKey;

	@Override
	public void run(String... args) throws Exception {
        System.out.println(appName);
        System.out.println(appPort);
        System.out.println(myKey);
		System.out.println(theara);
	}

}

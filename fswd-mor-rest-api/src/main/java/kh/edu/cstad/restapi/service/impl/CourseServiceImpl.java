package kh.edu.cstad.restapi.service.impl;

import kh.edu.cstad.restapi.domain.Course;
import kh.edu.cstad.restapi.dto.CourseResponse;
import kh.edu.cstad.restapi.dto.CreateCourseRequest;
import kh.edu.cstad.restapi.repository.CourseRepository;
import kh.edu.cstad.restapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public CourseResponse createCourse(CreateCourseRequest createCourseRequest) {

        // Validate course code
        boolean isCourseCodeExisted = courseRepository.getCourses()
                .stream()
                .anyMatch(course -> course.getCode().equals(createCourseRequest.code()));

        if (isCourseCodeExisted) {
            // CONFLICT
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Course code already exists"
            );
        }

        // Map dto to domain model
        Course course = Course.builder()
                .id(UUID.randomUUID().toString())
                .code(createCourseRequest.code())
                .title(createCourseRequest.title())
                .price(createCourseRequest.price())
                .status(false) // business logic
                .build();

        courseRepository.getCourses().add(course);

        // Return - Map from domain model to dto
        return CourseResponse.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .price(course.getPrice())
                .status(course.getStatus())
                .build();
    }


    @Override
    public List<CourseResponse> getCourses(Boolean status) {

        // Filter
        List<Course> filteredCourses = courseRepository.getCourses()
                .stream()
                .filter(course -> course.getStatus().equals(status))
                .toList();

        // Map data from domain model to DTO
        List<CourseResponse> courseResponseList = filteredCourses
                .stream()
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .toList();

        return courseResponseList;
    }

    @Override
    public List<CourseResponse> getCourses(Boolean status, String title) {
        return List.of();
    }

    @Override
    public CourseResponse getCourseByCode(String code) {
        return null;
    }

    @Override
    public CourseResponse getCourseById(String id) {
        return null;
    }

}

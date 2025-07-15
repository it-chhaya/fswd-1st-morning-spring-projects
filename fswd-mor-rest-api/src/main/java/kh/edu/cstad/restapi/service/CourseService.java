package kh.edu.cstad.restapi.service;

import kh.edu.cstad.restapi.domain.Course;
import kh.edu.cstad.restapi.dto.CourseResponse;
import kh.edu.cstad.restapi.dto.CreateCourseRequest;

import java.util.List;

public interface CourseService {


    /**
     * លុបវគ្គសិក្សាតាមយៈ course code
     * delete success response 204
     * if code doesn't exist response 404, "Course code doesn't exist"
     * @param code of course
     */
    void deleteCourseByCode(String code);


    // return type
    // data (parameter)
    // use for ?

    /**
     * បង្កើតទិន្នន័យវគ្គសិក្សាថ្មី
     * @param createCourseRequest ទិន្នន័យពី client
     * @return CourseResponse
     * @author CHAN CHHAYA
     */
    CourseResponse createCourse(CreateCourseRequest createCourseRequest);



    /**
     * ទាញព័ត៌មានវគ្គសិក្សាទាំងអស់
     * @author Sanom
     * @return List<CourseResponse>
     */
    List<CourseResponse> getCourses(Boolean status);

    List<CourseResponse> getCourses(Boolean status, String title);

    CourseResponse getCourseByCode(String code);

    CourseResponse getCourseById(String id);

}

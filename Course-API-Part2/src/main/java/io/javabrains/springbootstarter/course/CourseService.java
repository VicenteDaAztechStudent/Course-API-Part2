//SpringBoot QS 27-30


package io.javabrains.springbootstarter.course;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	// When instance of CourseService is created, Spring is going to inject
	// An instance of CourseRepository to it
	@Autowired
	private CourseRepository courseRepository;
	
	//Create method to return all 'courses'
	public List<Course> getAllCourses(String topicId){
		// Will find all Courses
		// And add each 'Course' element to the 'courses' list
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	// Create method to return specific course that matches 'id' parameter
	// Will check every 'id' to see if parameter 'id' that was passed
	// If it matches any from the list
	public Optional<Course> getCourse(String id) {

		return courseRepository.findById(id);
	}
	
	// Create method to add new instance of class 'Course' 
	// To ArrayList 'courses'
	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	
	public void updateCourse( Course course) {
		courseRepository.save(course);
		}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
		
	}
}


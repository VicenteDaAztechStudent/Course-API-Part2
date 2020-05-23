
package io.javabrains.springbootstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;


//Annotation to make class REST Controller
@RestController
public class CourseController {
	
	// Makes sure that instance of 'CourseService' is ready to be used
	@Autowired
	private CourseService courseService;
	
	// Annotation with parameter that takes request
	// When typing '/topics/{id}/courses' in the URL 
	// Returns all courses created from'CourseService' class
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	
	// Request mapping to one resource '' that matches input
	// Variable portion inside curly braces '{id}'must match method below 
	// 'Course getCoursec(String id)' to pass request for specific resource
	@RequestMapping ("/topics/topicId}/courses/{id}")
	
	// Returns a specific 'topic' if 'id' element match
	// Inside the instance of the class 'TopicService'
	// Which is object list 'topicService'
	// Sets parameter of  data type 'String' inside method below
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	// Creation of 'POST' request, only responsive when 'POST' is being called
	// Need to specify method in 'RequestMapping' annotation
	// Since by default uses 'GET' method
	@RequestMapping(method=RequestMethod.POST, value = "/topics/{topicId}/courses")
	
	// '@RequestBody' will convert content of the incoming 
	// Request (POST) body to your parameter object on the fly 
	// 'POST'/request should contain the object itself that's being sent 
	// After object is sent, it is passed as an instance of class 'Course'
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		
		course.setTopic(new Topic(topicId, "", ""));
		//(new Topic(topicId,"", ""));
		courseService.addCourse(course);
		
	}
	
	// Creation of 'PUT' request, only responsive when 'PUT' is being called
	// Variable portion inside curly braces '{id}'must match method's below 
	// 'updateTopic(@RequestBody Topic topic, @PathVariable String id)'
	// @PathVariable String 'id' to pass request to update specific resource
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	
	// '@RequestBody' will update content of the incoming 
	// Request (PUT) body to your parameter object on the fly 
	// 'POST'/request should contain the object itself that's being sent to update 
	// After object is sent, it is passed as an instance of class 'Topic'	
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId,  @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	// Creation of 'DELETE' request, only responsive when 'DELETE' is being called
	// Variable portion inside curly braces '{id}'must match method's below 
	// With  parameter of  data type 'String' inside method below
	// To successfully delete resource
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	
	// Deletes a specific 'topic' if 'id' above variable portion match 
	// With  parameter of  data type 'String' inside method below
	// Inside the instance of the class 'TopicService'
	// Which is object list 'topicService'

	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}

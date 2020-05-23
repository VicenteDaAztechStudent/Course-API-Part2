//SpringBoot QS 12
//SpringBoot QS 17
//SpringBoot QS 18

package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//Annotation to make class REST Controller
@RestController
public class TopicController {
	
	// Makes sure that instance of 'TopicService' is ready to be used
	@Autowired
	private TopicService topicService;
	
	// Annotation with parameter that takes request
	// When typing '/topics' in the URL 
	@RequestMapping("/topics")
	
	// Returns all topics created from'TopicService' class
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	
	 // Request mapping to one resource 'Topic' that matches input
	// Variable portion inside curly braces '{id}'must match method below 
	// 'Topic getTopic(String id)' to pass request for specific resource
	@RequestMapping ("/topics/{id}")
	
	// Returns a specific 'topic' if 'id' element match
	// Inside the instance of the class 'TopicService'
	// Which is object list 'topicService'
	// Sets parameter of  data type 'String' inside method below
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	// Creation of 'POST' request, only responsive when 'POST' is being called
	// Need to specify method in 'RequestMapping' annotation
	// Since by default uses 'GET' method
	@RequestMapping(method=RequestMethod.POST, value = "/topics")
	
	// '@RequestBody' will convert content of the incoming 
	// Request (POST) body to your parameter object on the fly 
	// 'POST'/request should contain the object itself that's being sent 
	// After object is sent, it is passed as an instance of class 'Topic'
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		
	}
	
	// Creation of 'PUT' request, only responsive when 'PUT' is being called
	// Variable portion inside curly braces '{id}'must match method's below 
	// 'updateTopic(@RequestBody Topic topic, @PathVariable String id)'
	// @PathVariable String 'id' to pass request to update specific resource
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{id}")
	
	// '@RequestBody' will update content of the incoming 
	// Request (PUT) body to your parameter object on the fly 
	// 'POST'/request should contain the object itself that's being sent to update 
	// After object is sent, it is passed as an instance of class 'Topic'	
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	// Creation of 'DELETE' request, only responsive when 'DELETE' is being called
	// Variable portion inside curly braces '{id}'must match method's below 
	// With  parameter of  data type 'String' inside method below
	// To successfully delete resource
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	
	// Deletes a specific 'topic' if 'id' above variable portion match 
	// With  parameter of  data type 'String' inside method below
	// Inside the instance of the class 'TopicService'
	// Which is object list 'topicService'

	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}

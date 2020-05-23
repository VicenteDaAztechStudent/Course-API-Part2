//SpringBoot QS 27-30


package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	// When instance of TopicService is created, Spring is going to inject
	// An instance of TopicRepository to it
	@Autowired
	private TopicRepository topicRepository;
	
	//Create method to return all 'Topics'
	public List<Topic> getAllTopics(){
		// Will find all Topics
		// And add each 'Topic' element to the 'topics' list
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	// Create method to return specific topic that matches 'id' parameter
	// Will check every 'id' to see if parameter 'id' that was passed
	// If it matches any from the list
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findById(id);
	}
	
	// Create method to add new instance of class 'Topic' 
	// To ArrayList 'topics'
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		
	}
}


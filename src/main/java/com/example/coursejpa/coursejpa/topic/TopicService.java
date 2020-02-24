package com.example.coursejpa.coursejpa.topic;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

//import com.example.studentDatabase.studentDatabse.student.Student;
//import com.example.studentDatabase.studentDatabse.student.StudentNotFoundException;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//it declares a dependency
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//				new Topic("spring", "Spring framework", "description"),
//				new Topic("java", "java framework", "description"),
//				new Topic("C++", "c++ framework", "description"),
//				new Topic("C", "C framework", "description")			
//				));
	
	public List<Topic> getAllTopics() {
		//		return topics;
		//findAll() returns a iterable of all the objects in db and we want to convert it to list 
		//we get a iterable so we iterate over it
		//we r using method reference here
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
//	public EntityModel<Topic> getTopic(String id) {
//		
////		topicRepository.findById(id);
//		Optional<Topic> topic = topicRepository.findById(id);
////		//this is to create a all-users mapping 
//		EntityModel<Topic> resource = new EntityModel<Topic>(topic.get());
//		//WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllTopics());
//		//resource.add(linkTo.withRel("all-users"));
//		return resource;
////		//this is lambda way of handling strings
////		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
////		System.out.println(topicRepository.findById(id));
////		return topicRepository.findById(id);
//	}

	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
	}
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	//add and update can be done using a single function save() only

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
//		for(int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
//		topics.removeIf(t -> t.getId().equals(id));
	}
}

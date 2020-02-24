package com.example.coursejpa.coursejpa.courses;

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
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//				new Topic("spring", "Spring framework", "description"),
//				new Topic("java", "java framework", "description"),
//				new Topic("C++", "c++ framework", "description"),
//				new Topic("C", "C framework", "description")			
//				));
	
	public List<Course> getAllCourses(String topicId) {
		//		return topics;
		//findByTopicId() returns a iterable of all the objects in db and we want to convert it to list 
		//we get a iterable so we iterate over it
		//we r using method reference here
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
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

	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);
	}
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	//add and update can be done using a single function save() only

	public void updateCourse(Course course) {
		courseRepository.save(course);
//		for(int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
//		topics.removeIf(t -> t.getId().equals(id));
	}
}

package com.example.coursejpa.coursejpa.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository  extends CrudRepository<Course, String>{
	
	//this would have worked if the topic would be an string.
//	public List<Course> findByTopic(String topicId);
	
	//what it means is that we need topic and in that topic we need id of that topic
	public List<Course> findByTopicId(String topicId);
	
	public List<Course> findByName(String name);
	public List<Course> findByDescription(String desc);
	//no matters what the entity is the structure remains same
	//so we have some common set of methods
	//	which will be repeated always=
//	getAllTopics()
//	getTopic(String id)
//	updateTopic(Topic t)
//	deleteTopic(String id)
//	CrudRepository has all the common methods we need 
//	here instead of JpaRepository we are using CrudRepository
}

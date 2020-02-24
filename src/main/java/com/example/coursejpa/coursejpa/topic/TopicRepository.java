package com.example.coursejpa.coursejpa.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository  extends CrudRepository<Topic, String>{

//	public List<Topic> findByTopicId(String id);
	public Optional<Topic> findById(String id);
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

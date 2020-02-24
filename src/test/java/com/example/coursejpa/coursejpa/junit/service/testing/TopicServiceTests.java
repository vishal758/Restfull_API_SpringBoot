package com.example.coursejpa.coursejpa.junit.service.testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.coursejpa.coursejpa.topic.Topic;
import com.example.coursejpa.coursejpa.topic.TopicRepository;
import com.example.coursejpa.coursejpa.topic.TopicService;

@RunWith(MockitoJUnitRunner.class)
public class TopicServiceTests {

	@InjectMocks
	TopicService topicService;
	
	
	@Mock
	TopicRepository  topicRepository;
	
	@Test
	public void getAllTopicsTest() {
//		public List<Topic> getAllTopics() {
//			List<Topic> topics = new ArrayList<>();
//			topicRepository.findAll().forEach(topics::add);
//			return topics;
//	}
		List<Topic> topics = new ArrayList<Topic>();
		topics.add(new Topic("C++", "C++ framework", "desc"));
		topics.add(new Topic("spring", "spring framework", "desc"));
		topics.add(new Topic("java", "java framework", "desc"));
		
		List<Topic> expected = new ArrayList<Topic>();
		expected.add(new Topic("C++", "C++ framework", "desc"));
		Mockito.when(topicRepository.findAll()).thenReturn(topics);
	    assertEquals(expected.get(0).getId(), topicService.getAllTopics().get(0).getId());
	}
	
	@Test
	public void getTopicTest() {
//		public Optional<Topic> getTopic(String id) {
//			return topicRepository.findById(id);
//		}
//		
		Optional<Topic> topics = Optional.of(new Topic("C++", "C++ framework", "desc"));
//		topics.add(new Topic("C++", "C++ framework", "desc"));
//		topics.add(new Topic("spring", "spring framework", "desc"));
//		topics.add(new Topic("java", "java framework", "desc"));
		
		List<Topic> expected = new ArrayList<Topic>();
		expected.add(new Topic("C++", "C++ framework", "desc"));
		Mockito.when(topicRepository.findById("C++")).thenReturn(topics);
	    assertEquals(expected.get(0).getId(), topicService.getTopic("C++").get().getId());
	}
	
}

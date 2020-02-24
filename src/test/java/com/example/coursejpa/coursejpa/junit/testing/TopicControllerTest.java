package com.example.coursejpa.coursejpa.junit.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.coursejpa.coursejpa.demotest.LearningController;
import com.example.coursejpa.coursejpa.demotest.LearningService;
import com.example.coursejpa.coursejpa.topic.Topic;
import com.example.coursejpa.coursejpa.topic.TopicController;
import com.example.coursejpa.coursejpa.topic.TopicService;


@RunWith(MockitoJUnitRunner.class)
public class TopicControllerTest {

@InjectMocks
private TopicController topicController;

@Mock
private TopicService topicService;

@Test
public void getTopicTest() {
//	@GetMapping("/topics/{id}")
//	public Optional<Topic> getTopic(@PathVariable String id) {
//		return topicService.getTopic(id);
////		return topicService.getTopic(id;)
//	}
	
	Optional<Topic> topic = Optional.of(new Topic("java", "java framework1", "description")); 
    Mockito.when(topicService.getTopic("java")).thenReturn(topic);
    //it is also correct
    //    assertEquals("java framework", topicController.getTopic("java").get().getName());
    
    //we can also do like this
    assertEquals("java", topicController.getTopic("java").get().getId());
}

@Test
public void getAllTopicsTest() {
//	@GetMapping("/topics")
//	public List<Topic> getAllTopics() {
//		return topicService.getAllTopics();
//	}
	
	List<Topic> topics = new ArrayList<Topic>() ;
	topics.add(new Topic("spring", "spring framework", "desc"));
	topics.add(new Topic("java", "java framework", "desc"));
	topics.add(new Topic("C++", "C++ framework", "desc"));
			
	List<Topic> expected = new ArrayList<Topic>();
	expected.add(new Topic("spring", "spring framework", "desc"));
	Mockito.when(topicService.getAllTopics()).thenReturn(topics);
	assertEquals(expected.get(0).getId(), topicController.getAllTopics().get(0).getId());
}


}

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = TopicController.class, secure = false)
//public class TopicControllerTest {
//
//
//		@Autowired
//		private MockMvc mockMvc;
//
//		@MockBean
//		private TopicService topicService;
//
//		Topic mockTopic = new Topic("C", "C framework", "description");
////		Course mockCourse = new Course("Course1", "Spring", "10 Steps",
////				Arrays.asList("Learn Maven", "Import Project", "First Example",
////						"Second Example"));
//
//		String exampleTopicJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
//
//		@Test
//		public void retrieveDetailsForTopic() throws Exception {
//
////			Mockito.when(topicService.getTopic(Mockito.anyString())).thenReturn(mockTopic);
//			Mockito.when(topicService.getTopic(Mockito.anyString())).thenReturn(mockTopic);
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//					"/topics/C").accept(
//					MediaType.APPLICATION_JSON);
//
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			
//
//			System.out.println(result.getResponse());
//			String expected = "{\"id\":\"C++\",\"name\":\"C++ framework updated\",\"description\":\"10 Steps\"}";
//
//			// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
//
//			JSONAssert.assertEquals(expected, result.getResponse()
//					.getContentAsString(), false);
//		}
//
//	}

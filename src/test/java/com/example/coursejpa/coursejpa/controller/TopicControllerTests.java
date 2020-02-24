package com.example.coursejpa.coursejpa.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.coursejpa.coursejpa.CourseJpaApplication;
import com.example.coursejpa.coursejpa.topic.Topic;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CourseJpaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicControllerTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	//get Topic
	@Test
	public void testgetTopic() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/topics/spring"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\n" + 
				"  \"id\": \"spring\",\n" + 
				"  \"name\": \"spring framework\",\n" + 
				"  \"description\": \"description\"\n" + 
				"}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	
	//Post working
	@Test
	public void addTopic() {

	Topic topic = new Topic("C++", "C++ framework", "10 Steps");

	HttpEntity<Topic> entity = new HttpEntity<Topic>(topic, headers);

	ResponseEntity<String> response = restTemplate.exchange(
	createURLWithPort("/topics"),
	HttpMethod.POST, entity, String.class);


	assertEquals(200,response.getStatusCodeValue());

	}
	//getAllTopic
	@Test
	public void testgetAllTopics() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/topics/"),
				HttpMethod.GET, entity, String.class);

		String expected = "  [\n" + 
				"  {\n" + 
				"    \"id\": \"C++\",\n" + 
				"    \"name\": \"C++ framework updated\",\n" + 
				"    \"description\": \"10 Steps\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": \"java\",\n" + 
				"    \"name\": \"java framework\",\n" + 
				"    \"description\": \"description\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": \"spring\",\n" + 
				"    \"name\": \"spring framework\",\n" + 
				"    \"description\": \"description\"\n" + 
				"  }\n" + 
				"]";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	//Put Request
	@Test
	public void updateTopic() {
		Topic topic = new Topic("C++", "C++ framework updated", "10 Steps");

		HttpEntity<Topic> entity = new HttpEntity<Topic>(topic, headers);

		ResponseEntity<String> response = restTemplate.exchange(
		createURLWithPort("/topics/" + topic.getId()),
		HttpMethod.PUT, entity, String.class);


		assertEquals(200,response.getStatusCodeValue());

	}

	//Delete Request
	@Test
	public void deleteTopic() {
//		Topic topic = new Topic("C++", "C++ framework updated", "10 Steps");
		String topic = "C++";
		HttpEntity<Topic> entity = new HttpEntity<Topic>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
		createURLWithPort("/topics/" + topic),
		HttpMethod.DELETE, entity, String.class);


		assertEquals(200,response.getStatusCodeValue());

	}
	
	
	
	
	
	
	
	
	/*
	 * wrong code
//	@Test
//	public void addTopic() {
//		///error
//		Topic topic = new Topic("C++", "C++ framework", "description");
//		HttpEntity<Topic> entity = new HttpEntity<Topic>(topic, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(
//				createURLWithPort("/topics"),
//				HttpMethod.POST, entity, String.class);
//
////		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
//		assertEquals(200, response.getStatusCodeValue());
////		-----------------------------------------------------------------------------------------------------	
////		assertTrue(actual.contains("/topics"));
//	} 
  */	
	
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
}

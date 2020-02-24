//package com.example.coursejpa.coursejpa.controller;
//
//
//
//
//
////package com.in28minutes.springboot.controller;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.skyscreamer.jsonassert.JSONAssert;
////import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.coursejpa.coursejpa.CourseJpaApplication;
//
////import com.in28minutes.springboot.StudentServicesApplication;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = CourseJpaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CourseControllerTests {
//
////	@LocalServerPort
////	private int port;
////
////	TestRestTemplate restTemplate = new TestRestTemplate();
////
////	HttpHeaders headers = new HttpHeaders();
//
//	@Test
//	public void testgetAllCourses() {
//
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(
//				createURLWithPort("/students/Student1/courses/Course1"),
//				HttpMethod.GET, entity, String.class);
//
//		String expected = "{id:Course1,name:Spring,description:10 Steps}";
//
//		Assert.assertEquals(expected, response.getBody(), false);
//	}
//
//	private String createURLWithPort(String uri) {
//		return "http://localhost:" + port + uri;
//	}
//
//}
//
////@RunWith(SpringRunner.class)
////@SpringBootTest(classes = CourseJpaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////public class CourseControllerTests {
////
////	@LocalServerPort
////	private int port;
////
////	TestRestTemplate restTemplate = new TestRestTemplate();
////
////	HttpHeaders headers = new HttpHeaders();
////
////	@Test
////	public void testgetAllCourse() {
////		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
////
////		ResponseEntity<String> response = restTemplate.exchange(
////				createURLWithPort("/topics/spring/courses/spring_2.0"),
////				HttpMethod.GET, entity, String.class);
////
////		String expected = "{id:spring_2.0,name:spring_2.0 framework,description:description,topic:{id: \"spring\",\n" +
////				"            \"name\": \"spring framework\",\n" +
////				"            \"description\": \"description\"\n" +
////				"        }}";
////
////		JSONAssert.assertEquals(expected, response.getBody(), false);
////
////	}
////
////}

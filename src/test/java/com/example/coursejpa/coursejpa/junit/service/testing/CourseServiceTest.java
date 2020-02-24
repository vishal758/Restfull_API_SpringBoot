package com.example.coursejpa.coursejpa.junit.service.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.coursejpa.coursejpa.courses.Course;
import com.example.coursejpa.coursejpa.courses.CourseRepository;
import com.example.coursejpa.coursejpa.courses.CourseService;
import com.example.coursejpa.coursejpa.topic.Topic;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

	
//	public Optional<Course> getCourse(String id) {
//		return courseRepository.findById(id);
//	}
	
	@InjectMocks
	CourseService courseService;
	
	
	@Mock
	CourseRepository courseRepository;
	
	@Test
	public void getCourseTest() {
//		public Optional<Course> getCourse(String id) {
//			return courseRepository.findById(id);
//		}
//		Optional<Course> course = Optional.of("java_2.0", "java_2.0 framework", "description", new Topic("sap", "sap framework", "desc"));
		Topic topic = new Topic("sap", "sap framework", "desc");
		Course course = new Course();
		course.setId("java_2.0");
		course.setId("java_2.0 desc");
		course.setId("desc");
		course.setTopic(topic);
//		Optional<Course> courseOptional = Optional.of(course);
		
//		Course expect = new Course();
//		expect.setId("java_2.0");
//		expect.setId("java_2.0 desc");
//		expect.setId("desc");
//		expect.setTopic(topic);
		
		Optional<Course> expected = Optional.of(course);
		
//		Optional<Course> expected = Optional.of("java_2.0", "java_2.0 framework", "description", topic);
		Mockito.when(courseRepository.findById("java_2.0")).thenReturn(expected);
		assertEquals(expected.get().getId(), courseService.getCourse("java_2.0").get().getId());
		
		
		
		
		
		
		
	}
	
	
	
}

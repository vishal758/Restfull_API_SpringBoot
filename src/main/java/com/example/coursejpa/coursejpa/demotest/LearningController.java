package com.example.coursejpa.coursejpa.demotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

//import com.example.demo.service.LearningService;

@RestController
public class LearningController {

@Autowired
private LearningService learningService;

@GetMapping("/get-name")
public String getName() {
String name = learningService.getName();
return name;
}
}
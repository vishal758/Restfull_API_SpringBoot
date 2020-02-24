package com.example.coursejpa.coursejpa.controller;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.coursejpa.coursejpa.demotest.LearningController;
import com.example.coursejpa.coursejpa.demotest.LearningService;

@RunWith(MockitoJUnitRunner.class)
public class LearningControllerTest {

@InjectMocks
private LearningController learningController;

@Mock
private LearningService learningService;

@Test
public void getNameTest() {
Mockito.when(learningService.getName()).thenReturn("udit");
assertEquals("udit",learningController.getName());
}
}

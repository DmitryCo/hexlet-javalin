package org.example.hexlet.dto.courses;


import java.util.List;

import org.example.hexlet.model.Course;
import org.example.hexlet.dto.main.BasePage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CoursePage extends BasePage {
    private List<Course> courses;
    private String term;
}
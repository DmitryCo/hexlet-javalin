package org.example.hexlet.dto.courses;

import java.util.List;

import org.example.hexlet.model.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CoursePage {
    private List<Course> courses;
    public String term;
}
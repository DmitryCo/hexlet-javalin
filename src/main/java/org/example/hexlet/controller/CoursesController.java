package org.example.hexlet.controller;

import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {

    public static void index(Context ctx) {
        List<Course> courses = CourseRepository.getEntities();
        var coursePage = new CoursePage(courses, "Список курсов");
        ctx.render("courses/index.jte", model("page", coursePage));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "Название курса должно быть не короче 2 символов")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Описание курса должно быть не короче 10 символов")
                    .get();
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        } catch (ValidationException e) {
            var page = new BuildCoursePage(ctx.formParam("name"), ctx.formParam("description"), e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        }
    }
}

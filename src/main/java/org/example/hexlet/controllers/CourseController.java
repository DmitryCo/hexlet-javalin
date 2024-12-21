package org.example.hexlet.controllers;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.utilities.NamedRoutes;

import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CourseController {

    public static void index(Context ctx) throws SQLException {

        var term = ctx.queryParam("term");
        var description = ctx.queryParam("description");
        var courses = CourseRepository.getEntities();
        var page = new CoursesPage(courses, term, description);
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Course with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        var name = ctx.formParam("name");
        var description = ctx.formParam("description");

        var course = new Course(name, description);
        CourseRepository.save(course);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}

package org.example.hexlet;

import org.example.hexlet.NamedRoutes;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.util.List;
import java.lang.String;

import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.validation.ValidationException;

import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.User;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.repository.CourseRepository;

import org.example.hexlet.controller.UsersController;
import org.example.hexlet.controller.CoursesController;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), ctx -> UsersController.build(ctx));
        app.post(NamedRoutes.usersPath(), ctx -> UsersController.create(ctx));

        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), ctx -> CoursesController.build(ctx));
        app.post(NamedRoutes.coursesPath(), ctx -> CoursesController.create(ctx));

        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500);
            ctx.result("Server Error: " + e.getMessage());
            e.printStackTrace(); // Выводит стек трейс в консоль
        });

        app.start(7070);
    }
}

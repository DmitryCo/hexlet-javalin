package org.example.hexlet;

import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.main.MainPage;
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
import org.example.hexlet.controller.SessionsController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.before(ctx -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedNow = now.format(formatter);
            System.out.println("Request received at: " + formattedNow);
        });

        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);

        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);

        /*app.get("/", ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited);
            ctx.render("main/index.jte", model("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });*/

        app.get("/", ctx -> {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("main/index.jte", model("page", page));
        });



        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500);
            ctx.result("Server Error: " + e.getMessage());
            e.printStackTrace(); // Выводит стек трейс в консоль
        });

        // Отображение формы логина
        app.get("/sessions/build", SessionsController::build);
        // Процесс логина
        app.post("/sessions", SessionsController::create);
        // Процесс выхода из аккаунта
        app.delete("/sessions", SessionsController::destroy);

        app.start(7070);
    }
}

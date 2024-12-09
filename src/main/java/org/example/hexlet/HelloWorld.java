package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.User;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.repository.CourseRepository;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        /*app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name");
            if (name == null || name.isEmpty()) {
                ctx.result("Hello, World!");
            } else {
                ctx.result("Hello, " + name + "!");
            }
        });

        /*app.get("/users/{id}/post/{postId}", ctx -> {
            var usersId = ctx.pathParam("id");
            var postId = ctx.pathParam("postId");
            ctx.result("Users ID: " + usersId + " Post ID: " + postId);
        });

        app.get("/users/{id}", ctx -> {
            var usersId = ctx.pathParam("id");
            ctx.contentType("html");
            ctx.result("&lt;h1&gt;" + usersId + "&lt;/h1&gt;");
        });

        app.get("/courses/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            List<Course> courses = List.of(
                    new Course(1L, "Java", "Основы Java, программирование на Java."),
                    new Course(2L, "Python", "Введение в Python, анализ данных с помощью Python."),
                    new Course(3L, "JavaScript", "Изучение основ JavaScript для веб-разработки."),
                    new Course(4L, "Ruby", "Введение в Ruby и создание веб-приложений с Ruby on Rails."));
            Course course = courses.stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            var header = "Курсы по программированию";
            if (course == null) {
                ctx.status(404).result("Курс не найден");
            } else {
                var page = new CoursePage(List.of(course), header);
                ctx.render("courses/show.jte", model("page", page));
            }
        });

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");

            List<Course> courses = List.of(
                    new Course(1L, "Java", "Основы Java, программирование на Java."),
                    new Course(2L, "Python", "Введение в Python, анализ данных с помощью Python."),
                    new Course(3L, "JavaScript", "Изучение основ JavaScript для веб-разработки."),
                    new Course(4L, "Ruby", "Введение в Ruby и создание веб-приложений с Ruby on Rails.")
            );

            // Фильтруем, только если была отправлена форма
            if (term != null && !term.isEmpty()) {
                courses = courses.stream()
                        .filter(course ->
                                course.getName().toLowerCase().contains(term.toLowerCase()) ||
                                course.getDescription().toLowerCase().contains(term.toLowerCase())
                        )
                        .toList();
            }
            var page = new CoursePage(courses, term);
            ctx.render("courses/index.jte", model("page", page));
        });*/

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var userPage = new UserPage(users, "Список пользователей");
            ctx.render("users/index.jte", model("page", userPage));
        });

        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.get("/courses", ctx -> {
            List<Course> courses = CourseRepository.getEntities();
            var coursePage = new CoursePage(courses, "Список пользователей");
            ctx.render("courses/index.jte", model("page", coursePage));
        });

        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });

        app.post("/courses", ctx -> {
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim();

            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        });

     app.start(7070);
    }
}

package org.example.hexlet;

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
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();

            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                        .get();
                var user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }
        });

        app.get("/courses", ctx -> {
            List<Course> courses = CourseRepository.getEntities();
            var coursePage = new CoursePage(courses, "Список курсов");
            ctx.render("courses/index.jte", model("page", coursePage));
        });

        app.get("/courses/build", ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
        });

        app.post("/courses", ctx -> {
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
        });

     app.start(7070);
    }
}

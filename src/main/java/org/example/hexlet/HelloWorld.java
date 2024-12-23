package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import org.example.hexlet.controllers.CourseController;
import org.example.hexlet.controllers.RootController;
import org.example.hexlet.controllers.SessionsController;
import org.example.hexlet.controllers.UsersController;
import org.example.hexlet.repository.BaseRepository;
import org.example.hexlet.utilities.NamedRoutes;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) throws Exception {

        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("postgresql://hexletjavalin_vzfg_user:vyjC646SuwBnIxLwlynLnoyYpAogQeWG@dpg-ctk2drlum" +
                "phs73fdueb0-a.oregon-postgres.render.com/hexletjavalin_vzfg");

        var dataSource = new HikariDataSource(hikariConfig);
        var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.mainPath(), RootController::index);

        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.editUserPath(), UsersController::edit);
        app.patch(NamedRoutes.userPath(), UsersController::update);
        app.delete(NamedRoutes.userPath(), UsersController::destroy);
        app.get(NamedRoutes.userPath(), UsersController::show);

        app.get(NamedRoutes.buildCoursesPath(), CourseController::build);
        app.get(NamedRoutes.coursesPath(), CourseController::index);
        app.get(NamedRoutes.coursePath(), CourseController::show);
        app.post(NamedRoutes.coursesPath(), CourseController::create);

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500);
            ctx.result("Server Error: " + e.getMessage());
            e.printStackTrace(); // Выводит стек трейс в консоль
        });

        app.start(7070);
    }
}
package org.example.hexlet;

public class NamedRoutes {

    // Маршрут пользователей
    public static String usersPath() {
        return "/users";
    }

    // Маршрут формы добавления пользователей
    public static String buildUserPath() {
        return "/users/build";
    }

    // Это нужно, чтобы не преобразовывать типы снаружи
    public static String usersPath(Long id) {
        return usersPath(String.valueOf(id));
    }

    public static String usersPath(String id) {
        return "/users/" + id;
    }

    // Маршрут формы добавления курсов
    public static String buildCoursePath() {
        return "/courses/build";
    }

    // Маршрут курсов
    public static String coursesPath() {
        return "/courses";
    }

    // Это нужно, чтобы не преобразовывать типы снаружи
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    public static String buildSessionsPath() {
        return "/sessions/build";
    }

    public static String sessionsPath() {
        return "/sessions";
    }
}

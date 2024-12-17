package org.example.hexlet.controller;

import org.example.hexlet.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");

        ctx.sessionAttribute("currentUser", name);
        ctx.redirect("/");
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
}

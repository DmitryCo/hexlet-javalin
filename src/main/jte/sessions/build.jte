@import org.example.hexlet.utilities.NamedRoutes

@template.layout.page(
title = "Authentication",
content = @`
    <form action="${NamedRoutes.sessionsPath()}" method="post">
        <input type="text" placeholder="Nickname" name="nickname" />
        <input type="password" placeholder="Password" name="password" />
        <input type="submit" />
    </form>
    `
)